package com.study.epamproject.service;

import com.study.epamproject.domain.order.Order;
import com.study.epamproject.domain.toy.Toy;

import java.util.List;

public interface OrderService<E extends Toy> {
    Order create();

    void addItem(Order order, E toy, int amount);

    void saveOrder(Order order);

    List<E> getAll(Order order);

    void remove(Order order, E toy, int amount);
}
