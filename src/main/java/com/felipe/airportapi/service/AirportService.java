package com.felipe.airportapi.service;

import com.felipe.airportapi.entity.Airport;
import com.felipe.airportapi.entity.dto.AirportDTO;
import com.felipe.airportapi.entity.repository.AirportJPA;
import com.felipe.airportapi.service.exceptions.AirportAlreadyExistsException;
import com.felipe.airportapi.service.exceptions.AirportNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AirportService {
    private final AirportJPA airportJPA;

    public AirportService(AirportJPA airportJPA) {
        this.airportJPA = airportJPA;
    }

    public List<Airport> getAirports() {
        return airportJPA.findAll();
    }

    public Airport getAirport(String airportId) {
        return airportJPA.findById(airportId)
                .orElseThrow(() -> new AirportNotFoundException(airportId));
    }

    public Airport saveAirport(AirportDTO airportDTO) {
        log.info("Saving airport: {}", airportDTO);
        Airport airport = convertToEntity(airportDTO);

        if (airportJPA.existsById(airportDTO.code())) {
            log.error("Airport already exists: {}", airportDTO);
            throw new AirportAlreadyExistsException(airportDTO.code());
        }

        Airport saved = airportJPA.save(airport);
        log.info("Airport saved successfully with ID: {}", saved.getAirportId());
        return saved;
    }

    public Airport updateAirport(AirportDTO airportDTO) {
        log.info("Updating airport: {}", airportDTO);

        Airport airport = airportJPA.findById(airportDTO.code())
                .orElseThrow(() -> new AirportNotFoundException(airportDTO.code()));

        airport.setName(airportDTO.name());
        airport.setCityName(airportDTO.cityName());

        Airport updatedAirport = airportJPA.save(airport);

        log.info("Airport updated successfully with ID: {}", updatedAirport.getAirportId());
        return updatedAirport;
    }

    public void deleteAirport(String airportId) {
        if (!airportJPA.existsById(airportId)) {
            throw new AirportNotFoundException(airportId);
        }
        airportJPA.deleteById(airportId);
    }


    private static Airport convertToEntity(AirportDTO dto) {
        Airport airport = new Airport();
        airport.setAirportId(dto.code());
        airport.setName(dto.name());
        airport.setCityName(dto.cityName());
        return airport;
    }
}
