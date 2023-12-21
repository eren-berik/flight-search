package com.erenberik.flightsearchapi.helper;

import com.erenberik.flightsearchapi.model.Airport;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class AirportDeserializer extends JsonDeserializer<Airport> {

    @Override
    public Airport deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException {
        int airportId = jsonParser.getValueAsInt();

        Airport airport = new Airport();
        airport.setId(airportId);
        return airport;
    }
}

