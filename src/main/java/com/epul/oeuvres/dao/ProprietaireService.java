package com.epul.oeuvres.dao;

import com.epul.oeuvres.metier.ProprietaireEntity;
import com.epul.oeuvres.repository.ProprietaireRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by clementserrano on 06/03/2018.
 */
public class ProprietaireService {

    @Autowired
    private ProprietaireRepository proprietaireRepository;

    /* Consultation des propriétaires */
    public List<ProprietaireEntity> consulterListeProp() {
        return proprietaireRepository.findAllOrderByNomProprietaire();
    }

    public ProprietaireEntity rechercherProprietaire(int id) {
        return proprietaireRepository.findByIdProprietaire(id);
    }
}
