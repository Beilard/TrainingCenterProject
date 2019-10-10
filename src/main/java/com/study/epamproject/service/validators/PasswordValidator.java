package com.study.epamproject.service.validators;

import com.study.epamproject.exceptions.InvalidPasswordFormatException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator implements Validator<String> {

    private Pattern pattern;
    private Matcher matcher;

    private static final String PASSWORD_PATTERN = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,40})";

    public PasswordValidator() {
        pattern = Pattern.compile(PASSWORD_PATTERN);
    }

    @Override
    public void validate(String item) {
        matcher = pattern.matcher(item);
        if (!(matcher.matches())) {
            throw new InvalidPasswordFormatException("Invalid password format!");
        }
    }
}
