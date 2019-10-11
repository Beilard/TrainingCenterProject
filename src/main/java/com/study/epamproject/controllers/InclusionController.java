package com.study.epamproject.controllers;

import com.study.epamproject.domain.order.Order;
import com.study.epamproject.repository.ToyRepository;
import com.study.epamproject.service.OrderService;
import com.study.epamproject.utililty.Messages;
import org.springframework.stereotype.Controller;

import static com.study.epamproject.utililty.ConsoleServiceUtility.*;

@Controller
public class InclusionController {

    private final OrderService<com.study.epamproject.domain.toy.Toy> orderService;

    public InclusionController(OrderService<com.study.epamproject.domain.toy.Toy> orderService) {
        this.orderService = orderService;
    }

    void add(Order order, ToyRepository toyRepository){
        write(Messages.getMessage("orderid"));
        Long id = (long) read();
        write("Please, enter the amount of items your would like to add: ");
        int amount = read();
        order.addToy(toyRepository.findById(id).get());
//        orderService.addItem(order, toyRepository.getToys().get(Math.toIntExact(id)), amount);
    }

    void remove(Order order, ToyRepository toyRepository){
        write("Please, enter the ID of the toy you want to remove: ");
        Long id = (long) read();
        orderService.remove(order, toyRepository.findById(id).get(), 10);
    }
}
