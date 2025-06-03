package com.felipe.airportapi.service;

import com.felipe.airportapi.service.exceptions.AirportAlreadyExistsException;
import com.felipe.airportapi.service.exceptions.AirportNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AirportAlreadyExistsException.class)
    public ResponseEntity<String> handleAirportAlreadyExistsException(AirportAlreadyExistsException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
    }

    @ExceptionHandler(AirportNotFoundException.class)
    public ResponseEntity<String> handleAirportNotFoundException(AirportNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
    }
}
