package com.felipe.airportapi.controller;

import com.felipe.airportapi.entity.Airport;
import com.felipe.airportapi.entity.dto.AirportDTO;
import com.felipe.airportapi.service.AirportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/airports")
public class AirportController {
    final AirportService airportService;
    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping
    public ResponseEntity<List<Airport>> getAirports() {
        List<Airport> airports = airportService.getAirports();
        return new ResponseEntity<>(airports, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Airport> getAirportById(@PathVariable String id) {
        Airport airport = airportService.getAirport(id);
        return new ResponseEntity<>(airport, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Airport> createAirport(@RequestBody AirportDTO airportDTO) {
        Airport airport = airportService.saveAirport(airportDTO);
        return new ResponseEntity<>(airport, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Airport> updateAirport(@RequestBody AirportDTO airportDTO) {
        Airport airport = airportService.updateAirport(airportDTO);
        return new ResponseEntity<>(airport, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAirport(@PathVariable String id) {
        airportService.deleteAirport(id);
        return ResponseEntity.noContent().build();
    }
}
