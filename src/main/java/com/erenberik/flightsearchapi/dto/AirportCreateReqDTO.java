package com.erenberik.flightsearchapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AirportCreateReqDTO {
    private String name;
    private Integer plateCode;
}
