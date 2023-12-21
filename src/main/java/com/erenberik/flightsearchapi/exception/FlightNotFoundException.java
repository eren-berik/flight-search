package com.erenberik.flightsearchapi.exception;

import java.io.Serial;

public class FlightNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1;

    public FlightNotFoundException(String message){
        super(message);
    }
}
