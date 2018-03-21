package com.epul.oeuvres.dao;

import com.epul.oeuvres.metier.OeuvreventeEntity;
import com.epul.oeuvres.repository.OeuvreventeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * Created by clementserrano on 06/03/2018.
 */
public class OeuvreVenteService {

    @Autowired
    private OeuvreventeRepository oeuvreventeRepository;

    public OeuvreventeEntity rechercherOeuvreIdParam(int id) {
        return oeuvreventeRepository.findOne(id);
    }

    /* Consultation des oeuvresVente */
    public List<OeuvreventeEntity> consulterListeOeuvresV() {
        return oeuvreventeRepository.findAll(new Sort(Sort.Direction.ASC, "titreOeuvrevente"));
    }

    public void insertOeuvreVente(OeuvreventeEntity oeuvrevente) {
        oeuvreventeRepository.save(oeuvrevente);
    }

    public void modifierOeuvre(OeuvreventeEntity oeuvrevente) {
        oeuvreventeRepository.save(oeuvrevente);
    }
}
