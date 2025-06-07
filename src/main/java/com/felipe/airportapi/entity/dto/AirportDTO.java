package com.felipe.airportapi.entity.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record AirportDTO(
        @NotNull String code,
        @NotNull String name,
        @NotNull @Positive String cityName
) { }
