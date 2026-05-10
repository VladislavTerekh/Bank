package com.bank.ui;

import com.bank.service.ClientService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class ConsoleMenu {

    private ClientService clientService;
    private Scanner scanner;

    public ConsoleMenu(ClientService clientService) {
        this.clientService = clientService;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while(true) { // Main menu loop
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1. Client Management");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    //call a new menu sheet
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }


            if (true) {
               return;
            }

        }

    }

    private void clientManagementMenu() {
        // TODO: CRUD menu
    }

}
