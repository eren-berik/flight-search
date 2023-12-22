package com.erenberik.flightsearchapi.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(
            name = "city_id"
    )
    private City city;

    public String getAirportName() {return String.format("%s - %s", getCity().getName(), getName());
    }
}
