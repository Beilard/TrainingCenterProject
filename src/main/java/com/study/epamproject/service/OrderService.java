package com.study.epamproject.service;

import com.study.epamproject.domain.toy.Toy;

import java.util.List;

public interface OrderService<E extends Toy> {
    void addItem(E toy, int amount);

    List<E> getAll();

    E update(E toy, int amount);

    boolean remove(E toy, int amount);
}
