package com.example.unicartagena.cea14.domain.exceptions;

public class ZoologicoException extends RuntimeException {

    public ZoologicoException(String message) {
        super(message);
    }
    public ZoologicoException(String message, Throwable cause) {
        super(message, cause);
    }
}
