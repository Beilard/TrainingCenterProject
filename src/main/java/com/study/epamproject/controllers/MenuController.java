package com.study.epamproject.controllers;

import com.study.epamproject.utililty.Messages;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

import static com.study.epamproject.utililty.ConsoleServiceUtility.*;

@Controller
public class MenuController {
    private static final Scanner IN = new Scanner(System.in);
    public static final String LANGUAGE = "Select your language:\n" + "1)Russian\n" + "2)English";

    private final LoginController loginController;
    private final RegistrationController registrationController;
    private final OrderController orderController;
    private final LanguageController languageController;

    public MenuController(LoginController loginController, RegistrationController registrationController, OrderController orderController, LanguageController languageController) {
        this.loginController = loginController;
        this.registrationController = registrationController;
        this.orderController = orderController;
        this.languageController = languageController;
    }

    public void start() {
        write(Messages.getMessage("greetings"));
        write(Messages.getMessage("login"));
        write(Messages.getMessage("registration"));
        write(Messages.getMessage("languagesel"));
        write(Messages.getMessage("exit"));
        write(" ");
        write(Messages.getMessage("options"));

        int option = read();
        selection(option);
    }


    private void selection(int option) {
        switch(option){
            case 1:
                loginController.login();
                break;
            case 2:
                registrationController.register();
                start();
                break;
            case 3:
                languageController.changeLanguage();
                break;
            case 4:
                System.exit(0);
                break;
            default:
                write("Wrong number input again:");
                start();
        }
    }
}
