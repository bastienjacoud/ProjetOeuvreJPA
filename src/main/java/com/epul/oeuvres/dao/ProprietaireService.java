package com.epul.oeuvres.dao;

import com.epul.oeuvres.meserreurs.MonException;
import com.epul.oeuvres.metier.ProprietaireEntity;

import javax.persistence.EntityTransaction;
import java.util.List;

/**
 * Created by clementserrano on 06/03/2018.
 */
public class ProprietaireService extends EntityService {

    /* Consultation des propriétaires
    Fabrique et renvoie une liste d'objets propriétaire contenant le résultat de
    la requête BDD */
    public List<ProprietaireEntity> consulterListeProp() throws MonException {
        List<ProprietaireEntity> mesProp = null;
        try {
            EntityTransaction transac = startTransaction();
            transac.begin();
            mesProp = (List<ProprietaireEntity>) entitymanager.createQuery("SELECT p FROM ProprietaireEntity p ORDER BY p.nomProprietaire").getResultList();
            entitymanager.close();
        } catch (RuntimeException e) {
            new MonException("Erreur de lecture", e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mesProp;
    }

    public ProprietaireEntity rechercherProprietaire(int id) throws MonException {
        ProprietaireEntity unProprietaire = null;
        try {
            EntityTransaction transac = startTransaction();
            transac.begin();
            unProprietaire = (ProprietaireEntity) entitymanager.createQuery("SELECT p FROM ProprietaireEntity WHERE idProprietaire=" + id).getSingleResult();
            entitymanager.close();
        } catch (RuntimeException e) {
            new MonException("Erreur de lecture", e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return unProprietaire;
    }
}
