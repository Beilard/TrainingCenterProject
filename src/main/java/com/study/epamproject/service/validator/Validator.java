package com.study.epamproject.service.validator;

public interface Validator<T> {
    public void validate(T user);
}
