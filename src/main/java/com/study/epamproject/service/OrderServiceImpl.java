package com.study.epamproject.service;

import com.study.epamproject.domain.toys.Toy;

import java.util.List;

public class OrderServiceImpl<E extends Toy> implements OrderService<Toy> {
    @Override
    public void addItem(Toy toy, int amount) {

    }

    @Override
    public List<Toy> getAll() {
        return null;
    }

    @Override
    public Toy update(Toy toy, int amount) {
        return null;
    }

    @Override
    public boolean remove(Toy toy, int amount) {
        return false;
    }
}
