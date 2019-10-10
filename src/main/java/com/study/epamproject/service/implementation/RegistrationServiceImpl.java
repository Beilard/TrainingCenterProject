package com.study.epamproject.service.implementation;

import com.study.epamproject.domain.user.Client;
import com.study.epamproject.domain.user.UserCredential;
import com.study.epamproject.repository.ClientRepository;
import com.study.epamproject.service.RegistrationService;
import com.study.epamproject.service.encoder.PasswordEncoder;
import com.study.epamproject.service.validator.Validator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    private static Long id = 0L;
    private final Validator validator;
    private final ClientRepository clientRepository;

    public RegistrationServiceImpl(@Qualifier("registrationValidator") Validator validator, ClientRepository clientRepository) {
        this.validator = validator;
        this.clientRepository = clientRepository;

    }

    @Override
    public boolean register(Client client) {
        validator.validate(client);
        Client anotherClient = new Client(new Client.ClientBuilder<>()
                .withId(id++)
                .withName(client.getName())
                .withSurname(client.getSurname())
                .withUserCredential(new UserCredential(client.getUserCredential().getEmail(),
                        PasswordEncoder.encrypt(client.getUserCredential().getPassword())))
                .withBudget(client.getBudget()));
        clientRepository.save(anotherClient);
        return true;
    }
}
