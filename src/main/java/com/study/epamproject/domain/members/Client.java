package com.study.epamproject.domain.members;

import com.study.epamproject.domain.toys.Toy;

import java.util.List;

public class Client extends User {
    private List<? extends Toy> orders;

    public Client(Long id, String name, String surname, String email, String password, List<? extends Toy> orders) {
        super(id, name, surname, email, password);
        this.orders = orders;
    }
}
