package com.felipe.airportapi.entity;

import com.felipe.airportapi.entity.auxiliary.State;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "FLIGHT")
public class Flight {
    @Id
    @Column(name = "FLIGHT_ID", nullable = false, length = 10)
    private String flightId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "ORIGIN_AIRPORT_ID", nullable = false)
    private Airport originAirport;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "DESTINATION_AIRPORT_ID", nullable = false)
    private Airport destinationAirport;

    @Column(name = "DEPARTURE_TIME", nullable = false)
    private Instant departureTime;
    @Column(name = "FREE_SEATS", nullable = false)
    private Integer freeSeats;
    @Column(name = "STATUS", columnDefinition = "ENUM not null")
    private State status;
}