package com.epul.oeuvres.repository;

import com.epul.oeuvres.metier.ReservationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.Repository;

import java.awt.print.Pageable;

/**
 * Created by clementserrano on 20/03/2018.
 */
public interface ReservationRepository extends Repository<ReservationEntity, Long> {
    Page<ReservationEntity> findAll(Pageable pageable);

    ReservationEntity save(ReservationEntity reservationEntity);
}
