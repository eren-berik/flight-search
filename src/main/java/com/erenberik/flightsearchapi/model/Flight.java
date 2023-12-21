package com.erenberik.flightsearchapi.model;

import com.erenberik.flightsearchapi.helper.AirportDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonDeserialize(using = AirportDeserializer.class)
    @ManyToOne
    @JoinColumn(name = "departure_airport")
    private Airport departureAirport;

    @JsonDeserialize(using = AirportDeserializer.class)
    @ManyToOne
    @JoinColumn(name = "arrival_airport")
    private Airport arrivalAirport;

    @Column(name = "departure_time")
    private LocalDateTime departureTime;

    @Column(name = "arrival_time")
    private LocalDateTime arrivalTime;

    private float price;

}
