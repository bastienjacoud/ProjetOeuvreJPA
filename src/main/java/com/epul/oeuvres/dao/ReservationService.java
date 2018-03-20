package com.epul.oeuvres.dao;

import com.epul.oeuvres.metier.OeuvreventeEntity;
import com.epul.oeuvres.metier.ReservationEntity;
import com.epul.oeuvres.repository.OeuvreventeRepository;
import com.epul.oeuvres.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by clementserrano on 06/03/2018.
 */
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private OeuvreventeRepository oeuvreventeRepository;

    public void reserverOeuvre(ReservationEntity reservation) {
        // Inserérer une réservation
        reservationRepository.save(reservation);

        // Modifier l'état
        OeuvreventeEntity oeuvrevente = reservation.getOeuvrevente();
        oeuvrevente.setEtatOeuvrevente("R");
        oeuvreventeRepository.save(oeuvrevente);
    }
}
