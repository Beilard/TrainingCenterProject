package com.study.epamproject.controllers;


import com.study.epamproject.service.implementations.ClientServiceImpl;
import sun.net.ResourceManager;

import java.util.Scanner;

public class Menu {
//    private static final ResourceManager MANAGER = ResourceManager.
    private static final Scanner IN = new Scanner(System.in);
    public static final String LANGUAGE = "Select your language:\n" + "1)Russian\n" + "2)English";

    private final ClientServiceImpl clientService;

    public Menu(ClientServiceImpl clientService) {
        this.clientService = clientService;
    }

    public void run() {

    }
}
