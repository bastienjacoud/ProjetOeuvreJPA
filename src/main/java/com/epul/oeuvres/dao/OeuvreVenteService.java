package com.epul.oeuvres.dao;

import com.epul.oeuvres.metier.OeuvreventeEntity;
import com.epul.oeuvres.repository.OeuvreventeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by clementserrano on 06/03/2018.
 */
public class OeuvreVenteService {

    @Autowired
    private OeuvreventeRepository oeuvreventeRepository;

    public OeuvreventeEntity rechercherOeuvreIdParam(int id) {
        return oeuvreventeRepository.findByIdOeuvrevente(id);
    }

    /* Consultation des oeuvresVente */
    public List<OeuvreventeEntity> consulterListeOeuvresV() {
        return oeuvreventeRepository.findAllOrderByTitreOeuvrevente();
    }

    public void insertOeuvreVente(OeuvreventeEntity oeuvrevente) {
        oeuvreventeRepository.save(oeuvrevente);
    }

    public void modifierOeuvre(OeuvreventeEntity oeuvrevente) {
        oeuvreventeRepository.save(oeuvrevente);
    }
}
