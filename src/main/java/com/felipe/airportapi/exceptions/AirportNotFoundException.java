package com.felipe.airportapi.exceptions;

public class AirportNotFoundException extends RuntimeException {
    public AirportNotFoundException(String airportId) {
        super("Airport not found with ID: " + airportId);
    }
}
