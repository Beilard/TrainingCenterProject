package com.study.epamproject.service.implementation;

import com.study.epamproject.domain.user.Client;
import com.study.epamproject.domain.user.UserCredential;
import com.study.epamproject.repository.ClientRepository;
import com.study.epamproject.service.LoginService;
import com.study.epamproject.service.validator.Validator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {
    private final Validator<UserCredential> validator;
    private final ClientRepository clientRepository;
    public LoginServiceImpl(@Qualifier("loginValidator") Validator validator, ClientRepository clientRepository) {
        this.validator = validator;
        this.clientRepository = clientRepository;
    }

    @Override
    public Optional<Client> login(String email, String password) {
        validator.validate(new UserCredential(email, password));
        return clientRepository.findByEmail(email);
    }
}
