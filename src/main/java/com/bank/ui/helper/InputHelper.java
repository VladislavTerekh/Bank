package com.bank.ui.helper;

import java.util.Scanner;

public class InputHelper {
    Scanner scanner;

    public InputHelper(Scanner scanner){
        this.scanner = scanner;
    }

    public int getIntInput() {
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    public String getNonEmptyString(String prompt) {
        while (true) {
            System.out.println(prompt);
            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println("Cannot be empty! Try again.");
        }
    }

    public String getEmailAddress(String prompt) {
        while (true) {
            System.out.println(prompt);
            String input = scanner.nextLine().trim();

            if (input.contains("@")) {
                return input;
            }

            System.out.println("Please, try again with valid email address");
        }
    }
}
