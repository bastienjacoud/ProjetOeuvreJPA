package com.epul.oeuvres.controle;

import com.epul.oeuvres.dao.AdherentService;
import com.epul.oeuvres.dao.OeuvreVenteService;
import com.epul.oeuvres.dao.ReservationService;
import com.epul.oeuvres.meserreurs.MonException;
import com.epul.oeuvres.metier.AdherentEntity;
import com.epul.oeuvres.metier.OeuvreventeEntity;
import com.epul.oeuvres.metier.ReservationEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by clementserrano on 06/03/2018.
 */
@Controller
public class ReservationControleur {

    private static final Logger logger = LoggerFactory.getLogger(MultiControleur.class);

    @RequestMapping(value = "reserverMenu.htm")
    public ModelAndView reserverMenu(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage;
        try {
            AdherentService adherentService = new AdherentService();
            OeuvreVenteService oeuvreVenteService = new OeuvreVenteService();

            // on retourne la liste des adhérents pour le select
            request.setAttribute("mesAdherents", adherentService.consulterListeAdherents());

            // on récupère l'oeuvres correspondant à l'id en paramètre
            OeuvreventeEntity oeuvrevente = oeuvreVenteService.rechercherOeuvreIdParam(
                    Integer.valueOf(request.getParameter("idOeuvre")));

            // on renvoi l'oeuvres pour initialiser les champs du formulaire
            request.setAttribute("oeuvres", oeuvrevente);
        } catch (MonException e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "Erreur";
        }
        destinationPage = "reserverOeuvre";
        return new ModelAndView(destinationPage);
    }

    @RequestMapping(value = "reserverOeuvre.htm")
    public ModelAndView reserverOeuvre(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage;
        try {
            AdherentService adherentService = new AdherentService();
            OeuvreVenteService oeuvreVenteService = new OeuvreVenteService();
            ReservationService reservationService = new ReservationService();

            ReservationEntity reservation = new ReservationEntity();

            // On récupère l'adhérent
            int idAdherent = Integer.valueOf(request.getParameter("idAdherent"));
            AdherentEntity adherent = adherentService.adherentById(idAdherent);

            // on récupère l'oeuvres
            int idOeuvrevente = Integer.valueOf(request.getParameter("idOeuvre"));
            OeuvreventeEntity oeuvrevente = oeuvreVenteService.rechercherOeuvreIdParam(idOeuvrevente);

            // On parse la date fournie
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String sDate = request.getParameter("date");
            Date date = null;
            try {
                date = new Date(sdf.parse(sDate).getTime());

                // Si le parse est OK, on réserve
                reservation.setIdAdherent(adherent.getIdAdherent());
                reservation.setDateReservation(date);
                reservation.setIdOeuvrevente(oeuvrevente.getIdOeuvrevente());
                reservation.setStatut("reservee");

                reservationService.reserverOeuvre(reservation);
                destinationPage = "forward:/listerOeuvre.htm";
            } catch (ParseException e) {
                request.setAttribute("MesErreurs", e.getMessage());
                destinationPage = "Erreur";
            }
        } catch (MonException e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "Erreur";
        }
        return new ModelAndView(destinationPage);
    }
}
