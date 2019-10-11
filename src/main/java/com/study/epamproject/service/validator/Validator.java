package com.study.epamproject.service.validator;

public interface Validator<T> {
    void validate(T user);
}
