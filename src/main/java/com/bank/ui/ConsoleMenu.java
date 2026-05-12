package com.bank.ui;

import com.bank.service.ClientService;
import com.bank.ui.helper.InputHelper;


import java.util.Scanner;

public class ConsoleMenu {

    private final ClientService clientService;
    private final Scanner scanner;
    private final InputHelper inputHelper;

    public ConsoleMenu(ClientService clientService) {
        this.clientService = clientService;
        this.scanner = new Scanner(System.in);
        this.inputHelper = new InputHelper(scanner);
    }

    public void start() {
        while(true) { // Main menu loop
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1. Client Management");
            System.out.println("0. Exit");

            int choice = inputHelper.getIntInput();

            switch (choice) {
                case 1:
                    clientManagementMenu();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }


        }

    }

    private void clientManagementMenu() {
        while (true) {
            System.out.println("\n=== CLIENT MANAGEMENT MENU ===");
            System.out.println("1. Create client");
            System.out.println("2. Create bank account for client");
            System.out.println("3. Get client info");
            System.out.println("4. Add funds");
            System.out.println("5. Withdraw funds");
            System.out.println("6. Get list of all clients");
            System.out.println("0. Back");

            int choice = inputHelper.getIntInput();

            if (choice == 0) {
                break;
            }

            ClientManagementMenu cmm = new ClientManagementMenu(scanner, clientService, inputHelper);

            switch (choice) {
                case 1:
                    // Call createClient()
                    break;
                case 2:
                    // Call createBankAccount()
                    break;
                case 3:
                    // Call getClientInfo()
                    break;
                case 4:
                    // Call addFunds()
                    break;
                case 5:
                    // Call withdrawFunds()
                    break;
                case 6:
                    // Call GetListOfAllClients()
                    break;
                default:
                    System.out.println("Invalid choice!");
            }




        }

    }

}
