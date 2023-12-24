package com.erenberik.flightsearchapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FlightSearchReq {
    private Long departureAirportId;
    private Long arrivalAirportId;
    private LocalDate departureTime;
    private Optional<LocalDate> returnTime;

}
