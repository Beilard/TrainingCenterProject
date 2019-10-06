package com.study.epamproject.validators;

import com.study.epamproject.domain.members.User;

public interface Validator<T> {
    public void validate(User item);
}
