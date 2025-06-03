package com.felipe.airportapi.service.exceptions;

public class AirportAlreadyExistsException extends RuntimeException {
    public AirportAlreadyExistsException(String code) {
        super("An airport with code " + code + " already exists");
    }
}
