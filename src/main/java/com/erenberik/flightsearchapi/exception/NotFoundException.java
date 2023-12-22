package com.erenberik.flightsearchapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NotFoundException extends BusinessException {

    public NotFoundException(BaseErrorMsg baseErrorMessage) {
        super(baseErrorMessage);
    }
}
