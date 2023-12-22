package com.erenberik.flightsearchapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AlreadyExistsException extends BusinessException {

    public AlreadyExistsException(BaseErrorMsg baseErrorMessage) {
        super(baseErrorMessage);
    }
}
