package com.study.epamproject.service.validator;

import com.study.epamproject.domain.user.Client;
import com.study.epamproject.domain.user.UserCredential;
import com.study.epamproject.exception.EntityNotFoundException;
import com.study.epamproject.exception.IncorrectEmailOrPasswordException;
import com.study.epamproject.exception.InvalidEmailFormatException;
import com.study.epamproject.exception.InvalidPasswordFormatException;
import com.study.epamproject.repository.ClientRepository;
import com.study.epamproject.service.encoder.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Component
public class LoginValidator implements Validator<UserCredential> {
    private static final String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
    private static final String PASSWORD_PATTERN = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,40})";

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
            throw new InvalidEmailFormatException("Email format not supported");
        }

        Optional<Client> client = clientRepository.findByEmail(userCredential.getEmail());

        if (!(client.isPresent())) {
            throw new EntityNotFoundException("Client not found!");
        }

        Matcher matcher = Pattern.compile(PASSWORD_PATTERN).matcher(userCredential.getPassword());
        if (!(matcher.matches())) {
            throw new InvalidPasswordFormatException("Invalid password format!");
        }


        String password = PasswordEncoder.decrypt(client.get().getUserCredential().getPassword());
        if (!(password.equals(userCredential.getPassword()))) {
            throw new IncorrectEmailOrPasswordException("Incorrect email or password!");
        }
    }
}
