package com.felipe.airportapi.entity.repository;

import com.felipe.airportapi.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportJPA extends JpaRepository<Airport, String> {

}
