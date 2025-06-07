package com.felipe.airportapi.entity.dto;

import jakarta.validation.constraints.NotNull;

public record AirportDTO(
        @NotNull String code,
        @NotNull String name,
        @NotNull String cityName
) { }
