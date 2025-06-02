package com.felipe.airportapi.entity.repository;

import com.felipe.airportapi.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerJPA extends JpaRepository<Passenger, String> {

}
