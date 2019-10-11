package com.study.epamproject.service.implementation;

import com.study.epamproject.domain.order.Order;
import com.study.epamproject.domain.toy.Toy;
import com.study.epamproject.exception.EntityNotFoundException;
import com.study.epamproject.repository.OrderRepository;
import com.study.epamproject.service.OrderService;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;

@Service
public class OrderServiceImpl<E extends Toy> implements OrderService<Toy> {
    private static Long id = 0L;
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @Override
    public Order create(){
        Order order = new Order(id++);
        return order;
    }

    @Override
    public void addItem(Order order, Toy toy, int amount) {
        orderValidator(order, toy, amount);
        order.addToy(toy);
    }

    @Override
    public void saveOrder(Order order) {
        if (order.getItems().size() != 0) {
            orderRepository.save(order);
        } else {
            try {
                throw new EntityNotFoundException("Order is empty!");
            } catch (EntityNotFoundException e) {
                System.out.println("Your order is empty!");
            }
        }
    }

    @Override
    public List<Toy> getAll(Order order) {
        try {
            if (order.getItems().isEmpty()) {
                throw new EntityNotFoundException("The called order's list is null");
            }
        } catch (EntityNotFoundException e) {
            System.out.println("The called order's list is null");
        }
        return order.getItems();
    }


    @Override
    public void remove(Order order, Toy toy, int amount) {
        orderValidator(order, toy, amount);
        for (int i = 0; i < amount; i++) {
            order.removeToy(toy);
        }
    }

    private void orderValidator(Order order, Toy toy, int amount) {
        try {
            if (toy.equals(null) || amount < 0) {
                throw new InvalidParameterException("Either toy or amount are null");
            }
        } catch (InvalidParameterException e) {
            System.out.println("Either toy null or amount of items is incorrect");
        }
    }
}
