package com.felipe.airportapi.exceptions;

public class AirportAlreadyExistsException extends RuntimeException {
    public AirportAlreadyExistsException(String code) {
        super("An airport with code " + code + " already exists");
    }
}
