package com.erenberik.flightsearchapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "departure_airport")
    private String departureAirport;

    @Column(name = "arrival_airport")
    private String arrivalAirport;

    @Column(name = "departure_time")
    private String departureTime;

    @Column(name = "arrival_time")
    private String arrivalTime;

    private float price;
}
