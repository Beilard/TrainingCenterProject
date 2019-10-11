package com.study.epamproject.service.implementation;

import com.study.epamproject.domain.user.Client;
import com.study.epamproject.domain.user.Director;
import com.study.epamproject.domain.user.UserCredential;
import com.study.epamproject.exception.EmailAlreadyTakenException;
import com.study.epamproject.repository.ClientRepository;
import com.study.epamproject.repository.implementation.ClientRepositoryImpl;
import com.study.epamproject.service.LoginService;
import com.study.epamproject.service.validator.LoginValidator;
import com.study.epamproject.service.validator.Validator;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.Assert.*;

public class LoginServiceImplTest {

    @MockBean
    private ClientRepository clientRepository = new ClientRepositoryImpl<>();
    private Validator<UserCredential> validator = new LoginValidator(clientRepository);
    private LoginService loginService = new LoginServiceImpl(validator,clientRepository);


    @Test
    public void shouldHaveNormalBehaviour() {
        Client actualClient = Director.createBob("bobross@mail.com", "Qwerty12345#");
        clientRepository.save(actualClient);
        Optional<Client> newClient = Optional.of(Director.createBob("bobross@mail.com", "Qwerty12345#"));
//        Mockito.when(clientRepository.findByEmail("bobross@mail.com")).thenReturn(newClient);
        Optional<Client> client = loginService.login("bobross@mail.com", "Qwerty12345#");
        assertEquals(client, actualClient);
    }

}