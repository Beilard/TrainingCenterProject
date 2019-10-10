//package com.study.epamproject.service.implementation;
//
//import com.study.epamproject.domain.user.Client;
//import com.study.epamproject.exception.EmailAlreadyTakenException;
//import com.study.epamproject.exception.EntityNotFoundException;
//import com.study.epamproject.repository.implementation.ClientRepositoryImpl;
//import com.study.epamproject.service.ClientService;
//import com.study.epamproject.service.encoder.PasswordEncoder;
//import com.study.epamproject.service.validator.PasswordValidator;
//import com.study.epamproject.service.validator.Validator;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class ClientServiceImpl implements ClientService<Client> {
//    private static final Logger LOGGER = LogManager.getLogger(ClientServiceImpl.class);
//    private final ClientRepositoryImpl clientRepository;
//    private final Validator validator;
//    private final PasswordValidator passwordValidator;
//    private final PasswordEncoder passwordEncoder;
//
//    public ClientServiceImpl(ClientRepositoryImpl clientRepository,
//                             Validator validator,
//                             PasswordValidator passwordValidator,
//                             PasswordEncoder passwordEncoder) {
//        this.clientRepository = clientRepository;
//        this.validator = validator;
//        this.passwordValidator = passwordValidator;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Override
//    public Client login(String email, String password) {
//        String encodedPassword = passwordEncoder.(password);
//        final Optional<Client> user = clientRepository.findByEmail(email);
//
//        try {
//            if (!user.isPresent()) {
//                throw new EntityNotFoundException("There is no user with this e-mail");
//            } else {
//                try {
//                    if (user.get().getUserCredential().getPassword().equals(encodedPassword)) {
//                        return user.get();
//                    } else {
//                        throw new EntityNotFoundException("Incorrect email or password");
//                    }
//                } catch (EntityNotFoundException e) {
//                    LOGGER.warn("Incorrect password", e);
//                }
//            }
//        } catch (EntityNotFoundException e) {
//            LOGGER.warn("There is no student with this e-mail", e);
//        }
//        return null;
//    }
//
//    @Override
//    public Client register(Client client) {
//        try {
//            if (clientRepository.findByEmail(client.getEmail()).isPresent()) {
//                throw new EmailAlreadyTakenException("This email is already taken");
//            }
//        } catch (EmailAlreadyTakenException e) {
//            LOGGER.warn("Trying to register with an already used email - " + client.getEmail(), e);
//            return null;
//        }
//        validator.validate(client);
//        passwordValidator.validate(client.getPassword());
//
//        return clientRepository.save(client);
//    }
//
//    @Override
//    public Client order() {
//        return null;
//    }
//}
