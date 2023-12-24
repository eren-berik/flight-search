package com.erenberik.flightsearchapi.cronJob;

import com.erenberik.flightsearchapi.dto.FlightCreateReqDTO;
import com.erenberik.flightsearchapi.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightDataSaveService {

    private final FlightService flightService;
    private final RestTemplate restTemplate;

    @Autowired
    public FlightDataSaveService(FlightService flightService, RestTemplateBuilder restTemplateBuilder) {
        this.flightService = flightService;
        this.restTemplate = restTemplateBuilder.build();
    }

    public void saveFlightDataFromExternalApi() {
        List<FlightCreateReqDTO> mockApiRes = mockApiReq();
        for (FlightCreateReqDTO flightCreateReqDTO: mockApiRes) {
            flightService.createFlight(flightCreateReqDTO);
        }
    }

    private List<FlightCreateReqDTO> mockApiReq() {

        //get the response from third part api here
        //return it

        return null;
    }
}
