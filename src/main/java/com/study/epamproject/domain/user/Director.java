package com.study.epamproject.domain.user;

public class Director {
    public static Client createBob(String email, String password) {
        Client client = new Client(new Client.ClientBuilder<>()
                .withName("Bob")
                .withSurname("Ross")
                .withBudget(600).withId(1L)
                .withUserCredential(new UserCredential(email, password)));
        return client;
    }
}
