package com.study.epamproject.controllers;

import com.study.epamproject.service.LoginService;
import org.springframework.stereotype.Component;

import static com.study.epamproject.utililty.ConsoleServiceUtility.*;

@Component
public class LoginController {
    private final LoginService loginService;
    private final OrderController orderController;

    public LoginController(LoginService loginService, OrderController orderController) {
        this.loginService = loginService;
        this.orderController = orderController;
    }

    public void login() {
        write("Please enter your email: ");
        String email = readString();
        write("Please enter your password: ");
        String password = readString();
        orderController.order(loginService.login(email, password).get());
    }
}
