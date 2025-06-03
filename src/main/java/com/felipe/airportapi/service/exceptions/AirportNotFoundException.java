package com.felipe.airportapi.service.exceptions;

public class AirportNotFoundException extends RuntimeException {
    public AirportNotFoundException(String airportId) {
        super("Airport not found with ID: " + airportId);
    }
}
