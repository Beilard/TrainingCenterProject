package com.study.epamproject.service.validator;

import com.study.epamproject.exception.InvalidPasswordFormatException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Component
public class PasswordValidator implements Validator<String> {

    private Pattern pattern;
    private Matcher matcher;

    private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
    private Logger logger = LogManager.getLogger("PasswordValidator.class");

    public PasswordValidator() {
        pattern = Pattern.compile(PASSWORD_PATTERN);
    }

    @Override
    public void validate(String item) {
        matcher = pattern.matcher(item);
        if (!(matcher.matches())) {
            logger.error("Invalid password format!");
            throw new InvalidPasswordFormatException("Invalid password format!");
        }
    }
}
