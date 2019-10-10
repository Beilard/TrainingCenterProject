package com.study.epamproject.repository.implementations;

import com.study.epamproject.domain.orders.Order;
import com.study.epamproject.repository.OrderRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class OrderRepositoryImpl implements OrderRepository {
    Map<Long, Order> idToOrder = new HashMap<>();

    @Override
    public Order save(Order item) {
        return idToOrder.put(item.getId(), item);
    }

    @Override
    public Optional<Order> findById(Long id) {
        return Optional.ofNullable(idToOrder.get(id));
    }

    @Override
    public List<Order> findAll() {
        return (List<Order>) idToOrder.values();
    }

    @Override
    public void update(Order item) {
        idToOrder.put(item.getId(), item);
    }

    @Override
    public Optional<Order> deleteById(Long id) {
        return Optional.ofNullable(idToOrder.remove(id));
    }
}
