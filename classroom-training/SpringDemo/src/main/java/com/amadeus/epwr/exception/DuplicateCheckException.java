package com.amadeus.epwr.exception;

public class DuplicateCheckException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DuplicateCheckException(String message) {
        super(message);
    }
}
