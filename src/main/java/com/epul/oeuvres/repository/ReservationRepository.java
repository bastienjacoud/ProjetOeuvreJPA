package com.epul.oeuvres.repository;

import com.epul.oeuvres.metier.ReservationEntity;
import com.epul.oeuvres.metier.ReservationEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by clementserrano on 20/03/2018.
 */
public interface ReservationRepository extends JpaRepository<ReservationEntity, ReservationEntityPK> {

}
