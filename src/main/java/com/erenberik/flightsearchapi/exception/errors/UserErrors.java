package com.erenberik.flightsearchapi.exception.errors;

import com.erenberik.flightsearchapi.exception.BaseErrorMsg;

public enum UserErrors implements BaseErrorMsg {
    USER_NOT_FOUND("User could not found"),

    USER_ALREADY_EXISTS("User already exists");
    private final String message;

    UserErrors(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
