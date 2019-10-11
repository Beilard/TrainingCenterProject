package com.study.epamproject.controllers;

import com.study.epamproject.domain.order.Order;
import com.study.epamproject.repository.ToyRepository;
import com.study.epamproject.service.OrderService;
import com.study.epamproject.utililty.Messages;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import static com.study.epamproject.utililty.ConsoleServiceUtility.*;

@Controller
public class InclusionController {

    private final OrderService  orderService;

    public InclusionController(OrderService orderService) {
        this.orderService = orderService;
    }

    void add(Order order, ToyRepository toyRepository){
        write(Messages.getMessage("orderid"));
        Long id = (long) read();
        write("Please, enter the amount of items your would like to add: ");
        int amount = read();
        orderService.addItem(order, toyRepository.findById(id).get(), amount);
    }

    void remove(Order order, ToyRepository toyRepository){
        write("Please, enter the ID of the toy you want to remove: ");
        Long id = (long) read();
        orderService.remove(order, toyRepository.findById(id).get(), 10);
    }
}
