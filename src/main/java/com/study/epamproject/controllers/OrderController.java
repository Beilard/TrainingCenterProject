package com.study.epamproject.controllers;

import com.study.epamproject.domain.order.Order;
import com.study.epamproject.repository.ToyRepository;
import com.study.epamproject.service.OrderService;
import org.springframework.stereotype.Component;

import static com.study.epamproject.utililty.ConsoleServiceUtility.*;

@Component
public class OrderController {
    private final ToyRepository toyRepository;
    private final OrderService orderService;
    private final InclusionController inclusionController;

    public OrderController(ToyRepository toyRepository, OrderService orderService, InclusionController inclusionController) {
        this.toyRepository = toyRepository;
        this.orderService = orderService;
        this.inclusionController = inclusionController;
    }

    public void order() {
        Order order = orderService.create();
        write("Here's a list of available toys: ");
        write("ID Item \t\t\t Price");
        write(toyRepository.toString());
        if (!(order.getItems().isEmpty())) {
            write("Your current order: " + order.getItems().toString());
        }
        write("Select your options");
        write("1. Add a toy to the order");
        write("2. Remove a toy from the order");
        write("3. Finish your order");
        int option = read();
        selection(option, order, toyRepository);
    }

    private void selection(int option, Order order, ToyRepository toyRepository) {
        switch (option) {
            case 1:
                inclusionController.add(order, toyRepository);
                break;
            case 2:
                inclusionController.remove(order, toyRepository);
                break;
            case 3:
                //
                break;
        }
    }
}
