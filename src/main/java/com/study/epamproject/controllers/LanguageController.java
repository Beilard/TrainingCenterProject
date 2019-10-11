package com.study.epamproject.controllers;

import com.study.epamproject.utililty.Messages;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import static com.study.epamproject.utililty.ConsoleServiceUtility.*;


@Controller
public class LanguageController {

    private final MenuController menuController;

    public LanguageController(@Lazy MenuController menuController) {
        this.menuController = menuController;
    }

    public void changeLanguage() {
        write("1.Select English");
        write("2.Select Ukrainian");
        write("Please select your option");
        int option = read();
        selection(option);
    }

    private void selection(int option) {
        switch (option) {
            case 1:
                Messages.setLocale(Messages.ENGLISH);
                menuController.start();
                break;
            case 2:
                Messages.setLocale(Messages.UKRAINIAN);
                menuController.start();
                break;
            default:
                write("Wrong number input again:");
                changeLanguage();
        }

    }
}