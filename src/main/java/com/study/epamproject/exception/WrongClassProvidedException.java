package com.study.epamproject.exception;

public class WrongClassProvidedException extends RuntimeException {
    public WrongClassProvidedException(String message) {
        super(message);
    }
}
