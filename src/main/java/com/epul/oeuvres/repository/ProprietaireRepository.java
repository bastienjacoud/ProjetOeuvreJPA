package com.epul.oeuvres.repository;

import com.epul.oeuvres.metier.ProprietaireEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.Repository;

import java.awt.print.Pageable;
import java.util.List;

/**
 * Created by clementserrano on 20/03/2018.
 */
public interface ProprietaireRepository extends Repository<ProprietaireEntity, Long> {
    Page<ProprietaireEntity> findAll(Pageable pageable);

    ProprietaireEntity save(ProprietaireEntity proprietaireEntity);

    List<ProprietaireEntity> findAllOrderByNomProprietaire();

    ProprietaireEntity findByIdProprietaire(int idProprietaire);
}
