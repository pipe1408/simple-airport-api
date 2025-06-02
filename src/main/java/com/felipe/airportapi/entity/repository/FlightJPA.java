package com.felipe.airportapi.entity.repository;

import com.felipe.airportapi.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightJPA extends JpaRepository<Flight, String> {

}
