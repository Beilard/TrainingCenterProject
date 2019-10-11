package com.study.epamproject.domain.user;

import java.util.List;
import java.util.Objects;

public class Client {
    private final List<Long> ordersById;
    private final Long id;
    private final String name;
    private final String surname;
    private final UserCredential userCredential;
    private final int budget;


    public Client(ClientBuilder<? extends ClientBuilder> clientBuilder) {
        this.ordersById = null;
        this.id = clientBuilder.id;
        this.name = clientBuilder.name;
        this.surname = clientBuilder.surname;
        this.userCredential = clientBuilder.userCredential;
        this.budget = clientBuilder.budget;
    }

    public ClientBuilder build() {
        return new ClientBuilder();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public UserCredential getUserCredential() {
        return userCredential;
    }

    public List<Long> getOrdersById() {
        return ordersById;
    }

    public int getBudget() {
        return budget;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Client)) {
            return false;
        }
        Client client = (Client) o;
        return budget == client.budget &&
                Objects.equals(ordersById, client.ordersById) &&
                Objects.equals(id, client.id) &&
                Objects.equals(name, client.name) &&
                Objects.equals(surname, client.surname) &&
                Objects.equals(userCredential, client.userCredential);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ordersById, id, name, surname, userCredential, budget);
    }

    public static class ClientBuilder<B extends ClientBuilder<B>> {
        private Long id;
        private String name;
        private String surname;
        private UserCredential userCredential;
        private int budget;

        public ClientBuilder() {
        }

        @SuppressWarnings("unchecked")
        public B self() {
            return (B) this;
        }

        public Client build() {
            return new Client(self());
        }

        public ClientBuilder<B> withId(Long id) {
            this.id = id;
            return this;
        }

        public ClientBuilder<B> withName(String name) {
            this.name = name;
            return this;
        }

        public ClientBuilder<B> withSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public ClientBuilder<B> withUserCredential(UserCredential userCredential) {
            this.userCredential = userCredential;
            return this;
        }


        public ClientBuilder<B> withBudget(int budget) {
            this.budget = budget;
            return this;
        }
    }
}
