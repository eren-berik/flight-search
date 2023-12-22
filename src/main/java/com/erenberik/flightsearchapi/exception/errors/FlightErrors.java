package com.erenberik.flightsearchapi.exception.errors;

import com.erenberik.flightsearchapi.exception.BaseErrorMsg;

public enum FlightErrors implements BaseErrorMsg {

    ALREADY_EXISTS("Flight is already exists"),

    FLIGHT_NOT_FOUND("Flight could not found"),
    ;
    private final String message;

    FlightErrors(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

