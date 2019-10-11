package com.study.epamproject.controllers;

import com.study.epamproject.service.LoginService;
import org.springframework.stereotype.Component;

import static com.study.epamproject.utililty.ConsoleServiceUtility.*;

@Component
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    public void login() {
        write("Please enter your email: ");
        String email = readString();
        write("Please enter your password: ");
        String password = readString();
        loginService.login(email, password);
    }
}
