package com.erenberik.flightsearchapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
public class City {

    @Id
    private Integer cityCode;

    private String name;

}
