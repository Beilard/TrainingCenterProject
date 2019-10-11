package com.study.epamproject.controllers;

import com.study.epamproject.domain.order.Order;
import com.study.epamproject.domain.toy.ToyDirector;
import com.study.epamproject.domain.user.Client;
import com.study.epamproject.repository.ToyRepository;
import com.study.epamproject.service.OrderService;
import com.study.epamproject.utililty.Messages;
import org.springframework.stereotype.Controller;

import static com.study.epamproject.utililty.ConsoleServiceUtility.*;

@Controller
public class OrderController {
    private final ToyRepository toyRepository;
    private final OrderService orderService;
    private final InclusionController inclusionController;

    public OrderController(ToyRepository toyRepository, OrderService orderService, InclusionController inclusionController) {
        this.toyRepository = toyRepository;
        this.orderService = orderService;
        this.inclusionController = inclusionController;
    }

    public void order(Client client) {
        if (toyRepository.getToys().size() == 0){
            autofill(toyRepository);
        }
        Order order = orderService.create();
        write(Messages.getMessage("toylist"));
        write("ID Item \t\t Price");
        write(toyRepository.toString());
        if (!(order.getItems().isEmpty())) {
            write("Your current order: " + order.getItems().toString());
        }
        write(Messages.getMessage("options"));
        write(Messages.getMessage("addToy"));
        write(Messages.getMessage("removeToy"));
        write(Messages.getMessage("sort"));
        write(Messages.getMessage("finish"));

        int option = read();
        selection(option, order, toyRepository);
        order(client);
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
                toyRepository.sortByPrice();
                break;
            case 4:
                orderService.saveOrder(order);
                write("Thanks for the order#" + order.getId());
                System.exit(0);
                break;
        }
    }

    private void autofill(ToyRepository toyRepository){
        toyRepository.save(ToyDirector.createBaseball());
        toyRepository.save(ToyDirector.createFootball());
        toyRepository.save(ToyDirector.createSkateboard());
        toyRepository.save(ToyDirector.createHoverboard());
    }
}


