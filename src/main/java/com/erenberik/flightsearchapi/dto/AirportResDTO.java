package com.erenberik.flightsearchapi.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AirportResDTO {
    private Long id;
    private String name;
    private Integer cityCode;
}