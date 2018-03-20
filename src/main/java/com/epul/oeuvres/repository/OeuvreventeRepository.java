package com.epul.oeuvres.repository;

import com.epul.oeuvres.metier.OeuvreventeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.Repository;

import java.awt.print.Pageable;
import java.util.List;

/**
 * Created by clementserrano on 20/03/2018.
 */
public interface OeuvreventeRepository extends Repository<OeuvreventeEntity, Long> {
    Page<OeuvreventeEntity> findAll(Pageable pageable);

    OeuvreventeEntity save(OeuvreventeEntity oeuvreventeEntity);

    OeuvreventeEntity findByIdOeuvrevente(int idOeuvrevente);

    List<OeuvreventeEntity> findAllOrderByTitreOeuvrevente();
}
