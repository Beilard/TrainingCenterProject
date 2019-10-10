package com.study.epamproject.exception;

public class IncorrectEmailOrPasswordException extends RuntimeException {
    public IncorrectEmailOrPasswordException(String message) {
        super(message);
    }
}
