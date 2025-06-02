package com.felipe.airportapi.entity.repository;

import com.felipe.airportapi.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationJPA extends JpaRepository<Reservation, String> {

}
