package com.study.epamproject.exceptions;

public class WrongClassProvidedException extends RuntimeException {
    public WrongClassProvidedException(String message) {
        super(message);
    }
}
