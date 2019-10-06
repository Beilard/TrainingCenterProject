package com.study.epamproject.domain.members;

import com.study.epamproject.domain.toys.Toy;

import javax.rmi.CORBA.StubDelegate;
import java.util.List;

public class Client extends User {
    private final List<? extends Toy> orders;
    private final Address address;

    protected Client(ClientBuilder clientBuilder) {
        super(clientBuilder);
        this.orders = clientBuilder.orders;
        this.address = clientBuilder.address;
    }

    public static class ClientBuilder extends UserBuilder<ClientBuilder> {
        private List<? extends Toy> orders;
        private Address address;

        public ClientBuilder() {
        }

        @Override
        public ClientBuilder self() {
            return this;
        }

        public Client build() {
            return new Client(self());
        }

        public ClientBuilder withOrders(List<? extends Toy> orders) {
            this.orders = orders;
            return this;
        }

        public ClientBuilder withAddress(Address address) {
            this.address = address;
            return this;
        }
    }
}
