package com.felipe.airportapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "AIRPORT")
public class Airport {
    @Id
    @Column(name = "AIRPORT_ID", nullable = false, length = 10)
    private String airportId;

    @Column(name = "NAME", nullable = false, length = 50)
    private String name;

    @Column(name = "CITY_NAME", nullable = false, length = 50)
    private String cityName;

}