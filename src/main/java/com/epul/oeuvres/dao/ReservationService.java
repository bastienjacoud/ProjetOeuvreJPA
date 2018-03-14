package com.epul.oeuvres.dao;

import com.epul.oeuvres.meserreurs.MonException;
import com.epul.oeuvres.metier.OeuvreventeEntity;
import com.epul.oeuvres.metier.ReservationEntity;

import javax.persistence.EntityTransaction;

/**
 * Created by clementserrano on 06/03/2018.
 */
public class ReservationService extends EntityService {
    public void reserverOeuvre(ReservationEntity reservation) throws MonException {
        try {
            EntityTransaction transac = startTransaction();
            transac.begin();

            // Inserérer une réservation
            entitymanager.persist(reservation);

            // Modifier l'état
            OeuvreVenteService oeuvreVenteService = new OeuvreVenteService();
            OeuvreventeEntity oeuvreventeEntity = reservation.getOeuvrevente();
            oeuvreventeEntity.setEtatOeuvrevente("R");

            transac.commit();
            entitymanager.close();
        } catch (RuntimeException e) {
            new MonException("Erreur de lecture", e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
