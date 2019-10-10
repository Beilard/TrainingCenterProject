package com.study.epamproject.controllers;



import org.springframework.stereotype.Component;

import java.util.Scanner;

import static com.study.epamproject.utililty.ConsoleServiceUtility.*;

@Component
public class MenuController {
//    private static final ResourceManager MANAGER = ResourceManager.
    private static final Scanner IN = new Scanner(System.in);
    public static final String LANGUAGE = "Select your language:\n" + "1)Russian\n" + "2)English";


    private final LoginController loginController;
    private final RegistrationController registrationController;

    public MenuController(LoginController loginController, RegistrationController registrationController) {
        this.loginController = loginController;
        this.registrationController = registrationController;
    }

    public void start() {
        write("Greetings in our store!");
        write("1. Login");
        write("2. Registration");
        write("3. Change language");
        write("4. Exit");
        write(" ");
        write("Please select your option");

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
                break;
            case 3:
                break;
            case 4:
                System.exit(0);

        }
    }
}
