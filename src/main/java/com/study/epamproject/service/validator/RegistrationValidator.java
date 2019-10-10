package com.study.epamproject.service.validator;

import com.study.epamproject.domain.user.Client;
import com.study.epamproject.domain.user.UserCredential;
import com.study.epamproject.exception.*;
import com.study.epamproject.repository.ClientRepository;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.regex.Pattern;

@Component
public class RegistrationValidator implements Validator<Client>{
    private static final String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
    private static final String PASSWORD_REGEX = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,40})";

    private final ClientRepository clientRepository;

    public RegistrationValidator(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void validate(Client user) {
        UserCredential userCredential = user.getUserCredential();

        if (Objects.isNull(userCredential)) {
            throw new EntityNotFoundException("Provided object is null!");
        }

        if (!userCredential.getEmail().matches(EMAIL_REGEX)) {
            throw new InvalidEmailFormatException("Email format not supported");
        }

        if (!userCredential.getPassword().matches(PASSWORD_REGEX)) {
            throw new InvalidEmailFormatException("Email format not supported");
        }

        if (clientRepository.findByEmail(userCredential.getEmail()).isPresent()) {
            throw new EmailAlreadyTakenException("Email already taken!");
        }

    }
}
