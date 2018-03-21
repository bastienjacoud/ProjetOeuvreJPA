package com.epul.oeuvres.dao;

import com.epul.oeuvres.metier.AdherentEntity;
import com.epul.oeuvres.repository.AdherentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by clementserrano on 06/03/2018.
 */
public class AdherentService {

    @Autowired
    private AdherentRepository adherentRepository;

    /* Insertion d'un adherent
     * param Adherent unAdherent
     * */
    public void insertAdherent(AdherentEntity unAdherent) {
        adherentRepository.save(unAdherent);
    }

    /* Lister les adherents
     * */
    public List<AdherentEntity> consulterListeAdherents() {
        return adherentRepository.findAll();
    }

    /* Consultation d'une adherent par son numéro
     */
    public AdherentEntity adherentById(int numero) {
        return adherentRepository.findOne(numero);
    }
}
