package com.study.epamproject.service.validator;


import com.study.epamproject.domain.user.Client;
import com.study.epamproject.domain.user.Director;
import com.study.epamproject.exception.EmailAlreadyTakenException;
import com.study.epamproject.exception.EntityNotFoundException;
import com.study.epamproject.exception.InvalidEmailFormatException;
import com.study.epamproject.repository.ClientRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

public class RegistrationValidatorTest {

    @MockBean
    private ClientRepository clientRepository;
    private RegistrationValidator registrationValidator = new RegistrationValidator(clientRepository);

    @Rule
    public ExpectedException exception = ExpectedException.none();


    @Test
    public void shouldThrowEntityNotFound() {
        exception.expect(EntityNotFoundException.class);
        exception.expectMessage("Provided object is null!");
        Client expectedClient = Director.createBob("Hey", "Bob");
        registrationValidator.validate(expectedClient);
    }

    @Test
    public void shouldThrowInvalidEmailException() {
        exception.expect(InvalidEmailFormatException.class);
        exception.expectMessage("Email format not supported");
        Client expectedClient = Director.createBob("Hey", "Bob");
        registrationValidator.validate(expectedClient);
    }

    @Test
    public void shouldThrowInvalidEmailExceptionForPassword() {
        exception.expect(InvalidEmailFormatException.class);
        exception.expectMessage("Email format not supported");
        Client expectedClient = Director.createBob("bobross@mail.com", "Bob");
        registrationValidator.validate(expectedClient);
    }

    @Test
    public void shouldThrowEmailAlreadyTakenException() {
        exception.expect(EmailAlreadyTakenException.class);
        exception.expectMessage("Email already taken!");
        Client expectedClient = Director.createBob("bobross@mail.com", "Qwerty12345#");
        Optional<Client> newClient = Optional.of(Director.createBob("bobross@mail.com", "Qwerty12345#"));
        Mockito.when(clientRepository.findByEmail("bobross@mail.com")).thenReturn(newClient);
        registrationValidator.validate(expectedClient);
    }
}