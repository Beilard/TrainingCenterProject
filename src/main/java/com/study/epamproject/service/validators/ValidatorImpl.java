package com.study.epamproject.service.validators;

import com.study.epamproject.domain.users.Client;
import com.study.epamproject.exceptions.EntityNotFoundException;
import com.study.epamproject.exceptions.InvalidEmailFormatException;
import com.study.epamproject.exceptions.WrongClassProvidedException;

import java.util.Objects;

public class ValidatorImpl<T extends Client> implements Validator<T> {
    private static final String REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

    @Override
    public void validate(T user) {
        if (!user.getEmail().matches(REGEX)) {
            throw new InvalidEmailFormatException("Email format not supported");
        }

        if (Objects.isNull(user)) {
            throw new EntityNotFoundException("Provided object is null!");
        }

        if (user instanceof Client) {
            throw new WrongClassProvidedException("Wrong class provided");
        }
    }
}
