package com.epul.oeuvres.repository;

import com.epul.oeuvres.metier.AdherentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.Repository;

import java.awt.print.Pageable;

/**
 * Created by clementserrano on 20/03/2018.
 */
public interface AdherentRepository extends Repository<AdherentEntity, Long> {
    Page<AdherentEntity> findAll(Pageable pageable);

    AdherentEntity save(AdherentEntity adherentEntity);

    AdherentEntity findByIdAdherent(int idAdherent);
}
