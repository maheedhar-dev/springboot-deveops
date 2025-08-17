package com.spring.devops.exception;

import java.io.Serial;

public class CountryAlreadyExistsException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;

    public CountryAlreadyExistsException(String message) {
        super(message);
    }

    public CountryAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public CountryAlreadyExistsException(Throwable cause) {
        super(cause);
    }
}
