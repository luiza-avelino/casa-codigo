package com.example.casa_do_codigo.exceptions;

public class EmailAlreadyInUseException extends RuntimeException {
    private final String message;

    public EmailAlreadyInUseException(String message) {
        super(message);
        this.message = message;
    }
}
