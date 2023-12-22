package com.erenberik.flightsearchapi.exception.errors;

import com.erenberik.flightsearchapi.exception.BaseErrorMsg;

public enum AirportErrors implements BaseErrorMsg {

    ALREADY_IN_USE("Airport is already in use"),

    AIRPORT_NOT_FOUND("Airport could not found"),
    ;
    private final String message;

    AirportErrors(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
