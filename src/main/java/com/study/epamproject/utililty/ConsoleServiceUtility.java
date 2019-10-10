package com.study.epamproject.utililty;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleServiceUtility {
    private static final Scanner scanner = new Scanner(System.in);

    public static int read() {
        while (!(scanner.hasNextInt()) ) {
            System.out.println("Wrong input detected. Try again");
            scanner.nextLine();
        }
        int i = scanner.nextInt();
        scanner.nextLine();
        return i;
    }

    public static String readString() {
        return scanner.nextLine();
    }

    public static void write(String input) {
        System.out.println(input);
    }
}
