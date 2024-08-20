package com.org.exceptions;

public class CustomException extends RuntimeException {
    private String message;

    public CustomException(String genericException) {
        this.message = genericException;
    }
}
