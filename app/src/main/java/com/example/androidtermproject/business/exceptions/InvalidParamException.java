package com.example.androidtermproject.business.exceptions;

public class InvalidParamException extends Exception {
    public InvalidParamException() {
    }

    public InvalidParamException(String message) {
        super(message);
    }
}
