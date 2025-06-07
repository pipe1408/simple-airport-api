package com.felipe.airportapi.entity.dto;

import com.felipe.airportapi.entity.helper.FlightStatus;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.sql.Time;
import java.sql.Timestamp;

public record FlightDTO(
        @NotNull String flightId,
        @NotNull String originId,
        @NotNull String destinationId,
        @NotNull FlightStatus flightStatus,
        @NotNull Timestamp departureTime,
        @NotNull @Positive Integer freeSeats
) { }
