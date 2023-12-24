package com.erenberik.flightsearchapi.mapper;

import com.erenberik.flightsearchapi.dto.FlightResDTO;
import com.erenberik.flightsearchapi.dto.FlightSearchResDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class FlightSearchMapper {

    public FlightSearchResDTO mapToFlightSearchResDTO(List<FlightResDTO> flights) {

        return FlightSearchResDTO.builder()
                .flights(flights)
                .build();

        /*if (inboundFlights.isPresent()) {

            return FlightSearchResDTO.builder()
                    .outboundFlights(outboundFlights)
                    .inboundFlights(inboundFlights.get())
                    .build();
        } else {

            return FlightSearchResDTO.builder()
                    .outboundFlights(outboundFlights)
                    .build();
        }*/
    }
}
