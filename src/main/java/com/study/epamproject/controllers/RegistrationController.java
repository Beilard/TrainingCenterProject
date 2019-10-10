package com.study.epamproject.controllers;
import com.study.epamproject.domain.user.Client;
import com.study.epamproject.domain.user.UserCredential;
import com.study.epamproject.service.RegistrationService;
import org.springframework.stereotype.Component;

import static com.study.epamproject.utililty.ConsoleServiceUtility.*;
@Component
public class RegistrationController {
    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    public void register() {
        write("Please enter your email: ");
        String email = readString();
        write("Please enter your password: ");
        String password = readString();
        write("Please enter your budget: ");
        int budget = read();
        write("Please enter your name: ");
        String name = readString();
        write("Please enter your surname: ");
        String surname = readString();
        UserCredential userCredential = new UserCredential(email, password);

        Client client = new Client(new Client.ClientBuilder<>()
                                    .withName(name)
                                    .withSurname(surname)
                                    .withBudget(budget)
                                    .withUserCredential(userCredential));

        registrationService.register(client);

    }
}
