package com.study.epamproject.service;

import com.study.epamproject.domain.users.Client;
import com.study.epamproject.exceptions.EntityNotFoundException;
import com.study.epamproject.repository.implementations.ClientRepositoryImpl;
import com.study.epamproject.service.encoder.PasswordEncoder;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class ClientServiceImpl<E> implements ClientService<E> {
    private static final Logger LOGGER = Logger.getLogger("file");
    private final ClientRepositoryImpl clientRepository;
    private final PasswordEncoder passwordEncoder;

    public ClientServiceImpl(ClientRepositoryImpl clientRepository, PasswordEncoder passwordEncoder) {
        this.clientRepository = clientRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Client login(String email, String password) {
        String encodedPassword = passwordEncoder.encode(password);
        final Optional<Client> user = clientRepository.findByEmail(email);

        try {
            if (!user.isPresent()) {
                throw new EntityNotFoundException("There is no user with this e-mail");
            } else {
                try {
                    if (user.get().getPassword().equals(encodedPassword)) {
                        return user.get();
                    } else {
                        throw new EntityNotFoundException("Incorrect email or password");
                    }
                } catch (EntityNotFoundException e) {
                    LOGGER.warn("Incorrect password", e);
                }
            }
        } catch (EntityNotFoundException e) {
            LOGGER.warn("There is no student with this e-mail", e);
        }

        return null;
    }

    @Override
    public E register(E e) {
        return null;
    }

    @Override
    public E order() {
        return null;
    }
}
