package com.study.epamproject.service.validators;

public interface Validator<T> {
    public void validate(T user);
}
