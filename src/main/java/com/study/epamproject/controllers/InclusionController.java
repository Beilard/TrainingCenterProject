package com.study.epamproject.controllers;

import com.study.epamproject.domain.order.Order;
import com.study.epamproject.repository.ToyRepository;
import com.study.epamproject.service.OrderService;
import org.springframework.stereotype.Component;

import static com.study.epamproject.utililty.ConsoleServiceUtility.*;

@Component
public class InclusionController {

    private final OrderService  orderService;

    public InclusionController(OrderService orderService) {
        this.orderService = orderService;
    }

    void add(Order order, ToyRepository toyRepository){
        write("Please, enter the ID of the toy you want to add: ");
        Long id = (long) read();
        write("Please, enter the amount of items your would like to add: ");
        int amount = read();
        orderService.addItem(order, toyRepository.findById(id).get(), amount);
    }

    void remove(Order order, ToyRepository toyRepository){
        write("Please, enter the ID of the toy you want to add: ");
        Long id = (long) read();
        orderService.remove(order, toyRepository.findById(id).get(), 10);
    }
}
