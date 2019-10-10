package com.study.epamproject.domain.users;

import java.util.List;

public class Client {
    private final List<Long> ordersById;
    private final Long id;
    private final String name;
    private final String surname;
    private final String email;
    private final String password;
    private final Address address;
    private final int budget;


    public Client(ClientBuilder<? extends ClientBuilder> clientBuilder) {
        this.ordersById = null;
        this.id = clientBuilder.id;
        this.name = clientBuilder.name;
        this.surname = clientBuilder.surname;
        this.email = clientBuilder.email;
        this.password = clientBuilder.password;
        this.address = clientBuilder.address;
        this.budget = clientBuilder.budget;
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

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<Long> getOrdersById() {
        return ordersById;
    }

    public Address getAddress() {
        return address;
    }

    public int getBudget() {
        return budget;
    }

    public static class ClientBuilder<B extends ClientBuilder<B>> {
        private Long id;
        private String name;
        private String surname;
        private String email;
        private String password;
        private Address address;
        private int budget;

        protected ClientBuilder() {
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

        public ClientBuilder<B> withEmail(String email) {
            this.email = email;
            return this;
        }

        public ClientBuilder<B> withPassword(String password) {
            this.password = password;
            return this;
        }

        public ClientBuilder<B> withAddress(Address address) {
            this.address = address;
            return this;
        }

        public ClientBuilder<B> withBudget(int budget) {
            this.budget = budget;
            return this;
        }
    }
}
