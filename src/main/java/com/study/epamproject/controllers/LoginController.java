package com.study.epamproject.controllers;

import com.study.epamproject.domain.user.Client;
import com.study.epamproject.domain.user.Director;
import com.study.epamproject.service.LoginService;
import com.study.epamproject.utililty.Messages;
import org.springframework.stereotype.Controller;

import static com.study.epamproject.utililty.ConsoleServiceUtility.*;

@Controller
public class LoginController {
    private final LoginService loginService;
    private final OrderController orderController;

    public LoginController(LoginService loginService, OrderController orderController) {
        this.loginService = loginService;
        this.orderController = orderController;
    }

    public void login() {
        write(Messages.getMessage("email"));
        String email = readString();
        write(Messages.getMessage("password"));
        String password = readString();
        orderController.order(loginService.login(email, password).get());
    }

    private Client autofill() {
        return Director.createBob("ivan@gmail.com", "Qwerty1234#");
    }
}
