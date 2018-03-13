package com.epul.oeuvres.dao;

import com.epul.oeuvres.meserreurs.MonException;
import com.epul.oeuvres.metier.OeuvreventeEntity;

import javax.persistence.EntityTransaction;
import java.util.List;

/**
 * Created by clementserrano on 06/03/2018.
 */
public class OeuvreVenteService extends EntityService {
    public OeuvreventeEntity rechercherOeuvreIdParam(int id) throws MonException {
        OeuvreventeEntity uneOeuvre = null;
        try {
            EntityTransaction transac = startTransaction();
            transac.begin();
            uneOeuvre = (OeuvreventeEntity) entitymanager.createQuery("SELECT idOeuvrevente, titreOeuvrevente, etatOeuvrevente, prixOeuvrevente " +
                    "FROM OeuvreventeEntity WHERE idOeuvrevente=" + id).getSingleResult();
            entitymanager.close();
        } catch (RuntimeException e) {
            new MonException("Erreur de lecture", e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return uneOeuvre;

    }

    /* Consultation des oeuvresVente
    Fabrique et renvoie une liste d'objets oeuvreVente contenant le résultat de
    la requête BDD */
    public List<OeuvreventeEntity> consulterListeOeuvresV() throws MonException {
        List<OeuvreventeEntity> mesOeuvresV = null;
        try {
            EntityTransaction transac = startTransaction();
            transac.begin();
            mesOeuvresV = (List<OeuvreventeEntity>) entitymanager.createQuery("SELECT o FROM OeuvreventeEntity o ORDER BY o.titreOeuvrevente").getResultList();
            entitymanager.close();
        } catch (RuntimeException e) {
            new MonException("Erreur de lecture", e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mesOeuvresV;
    }

    public void insertOeuvreVente(OeuvreventeEntity oeuvrevente) {
        try {
            EntityTransaction transac = startTransaction();
            transac.begin();
            entitymanager.persist(oeuvrevente);
            transac.commit();
            entitymanager.close();
        } catch (RuntimeException e) {
            new MonException("Erreur de lecture", e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void modifierOeuvre(OeuvreventeEntity oeuvrevente) throws MonException {
        try {
            EntityTransaction transac = startTransaction();
            transac.begin();
            transac.commit();
            entitymanager.close();
        } catch (RuntimeException e) {
            new MonException("Erreur de lecture", e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
