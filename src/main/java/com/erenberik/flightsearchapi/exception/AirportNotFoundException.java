package com.erenberik.flightsearchapi.exception;

import java.io.Serial;

public class AirportNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1;

    public AirportNotFoundException(String message){
        super(message);
    }
}
