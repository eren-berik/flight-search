package com.erenberik.flightsearchapi.mapper;

import com.erenberik.flightsearchapi.dto.FlightResDTO;
import com.erenberik.flightsearchapi.dto.FlightSearchResDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class FlightSearchMapper {
    public FlightSearchResDTO mapToFlightSearchResDTO(List<FlightResDTO> outboundFlights, List<FlightResDTO> inboundFlights) {
        return FlightSearchResDTO.builder()
                .outboundFlights(outboundFlights)
                .inboundFlights(inboundFlights)
                .build();
    }

    public FlightSearchResDTO mapToFlightSearchResDTO(List<FlightResDTO> outboundFlights) {
        return FlightSearchResDTO.builder()
                .outboundFlights(outboundFlights)
                .inboundFlights(List.of())
                .build();
    }

}
