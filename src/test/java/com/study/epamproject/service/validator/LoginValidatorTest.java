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

public class LoginValidatorTest {

    @MockBean
    private ClientRepository clientRepository;
    private LoginValidator loginValidator = new LoginValidator(clientRepository);

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldEmailFormatNotSupported() {
        exception.expect(InvalidEmailFormatException.class);
        exception.expectMessage("Email format not supported");
        Client expectedClient = Director.createBob("Hey", "Bob");
        loginValidator.validate(expectedClient.getUserCredential());
    }

    @Test
    public void shouldThrowInvalidEmailException() {
        exception.expect(InvalidEmailFormatException.class);
        exception.expectMessage("Email format not supported");
        Client expectedClient = Director.createBob("Hey", "Bob");
        loginValidator.validate(expectedClient.getUserCredential());
    }

    @Test
    public void shouldThrowInvalidEmailExceptionForPassword() {
        exception.expect(InvalidEmailFormatException.class);
        exception.expectMessage("Email format not supported");
        Client expectedClient = Director.createBob("bobross@mail.com", "Bob");
        loginValidator.validate(expectedClient.getUserCredential());
    }

    @Test
    public void shouldThrowEmailAlreadyTakenException() {
        exception.expect(EmailAlreadyTakenException.class);
        exception.expectMessage("Email already taken!");
        Client expectedClient = Director.createBob("bobross@mail.com", "Qwerty12345#");
        Optional<Client> newClient = Optional.of(Director.createBob("bobross@mail.com", "Qwerty12345#"));
        Mockito.when(clientRepository.findByEmail("bobross@mail.com")).thenReturn(newClient);
        loginValidator.validate(expectedClient.getUserCredential());
    }
}