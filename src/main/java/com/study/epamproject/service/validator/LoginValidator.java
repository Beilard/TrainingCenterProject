package com.study.epamproject.service.validator;

import com.study.epamproject.domain.user.Client;
import com.study.epamproject.domain.user.UserCredential;
import com.study.epamproject.exception.EntityNotFoundException;
import com.study.epamproject.exception.IncorrectEmailOrPasswordException;
import com.study.epamproject.exception.InvalidEmailFormatException;
import com.study.epamproject.exception.InvalidPasswordFormatException;
import com.study.epamproject.repository.ClientRepository;
import com.study.epamproject.service.encoder.PasswordEncoder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Component
public class LoginValidator implements Validator<UserCredential> {
    private static final String EMAIL_REGEX = "^(.+)@(.+)$";
    private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";

    private Logger logger = LogManager.getLogger("LoginValidator.class");

    private final ClientRepository clientRepository;

    public LoginValidator(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;

    }

    @Override
    public void validate(UserCredential userCredential) {

        if (Objects.isNull(userCredential)) {
            throw new EntityNotFoundException("Provided object is null!");
        }

        if (!userCredential.getEmail().matches(EMAIL_REGEX)) {
            logger.error("Email format not supported " + userCredential.getEmail());
            throw new InvalidEmailFormatException("Email format not supported");
        }

        Optional<Client> client = clientRepository.findByEmail(userCredential.getEmail());

        if (!(client.isPresent())) {
            logger.error("Client not found!");
            throw new EntityNotFoundException("Client not found!");
        }

        Matcher matcher = Pattern.compile(PASSWORD_PATTERN).matcher(userCredential.getPassword());
        if (!(matcher.matches())) {
            logger.error("Invalid password format!");
            throw new InvalidPasswordFormatException("Invalid password format!");
        }


        String password = PasswordEncoder.decrypt(client.get().getUserCredential().getPassword());
        if (!(password.equals(userCredential.getPassword()))) {
            logger.error("Incorrect email or password!");
            throw new IncorrectEmailOrPasswordException("Incorrect email or password!");
        }
    }
}
