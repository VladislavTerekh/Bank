package com.bank.ui;

import com.bank.exception.UserEmailAlreadyInUseException;
import com.bank.exception.UserPhoneNumberAlreadyInUseException;
import com.bank.model.Client;
import com.bank.model.Currency;
import com.bank.service.BankAccountService;
import com.bank.service.ClientService;
import com.bank.service.TransactionService;
import com.bank.ui.helper.InputHelper;
import com.bank.ui.helper.PrintHepler;

import java.sql.SQLException;

public class ClientManagementMenu {
    private final ClientService clientService;
    private final BankAccountService bankAccountService;
    private final TransactionService transactionService;
    private final InputHelper inputHelper;
    private final PrintHepler printHepler;
    private final String additionalMsg = " / enter 0 to abort whole operation: ";

    public ClientManagementMenu(ClientService clientService, BankAccountService bankAccountService, TransactionService transactionService, InputHelper inputHelper, PrintHepler printHepler) {
        this.clientService = clientService;
        this.bankAccountService = bankAccountService;
        this.transactionService = transactionService;
        this.inputHelper = inputHelper;
        this.printHepler = printHepler;
    }

    public void createClient() {


        String firstName = inputHelper.getNonEmptyString("To create a new client, enter name" + additionalMsg);
        if (firstName.equals("0")) return;

        String secondName = inputHelper.getNonEmptyString("Enter second name" + additionalMsg);
        if (secondName.equals("0")) return;


        String email;
        while (true) {
            email = inputHelper.getEmailAddress("Enter email" + additionalMsg);
            if (email.equals("0")) return;

            try {
                if (!clientService.isEmailExists(email)) {
                    break;
                } else {
                    System.out.println("Email is already in use, try another one");
                }
            } catch (SQLException e) {
                System.out.println("Couldn't check email existence, try again later.");
            }
        }



        String phoneNumber;
        while (true) {
            phoneNumber = inputHelper.getNonEmptyString("Enter phone number" + additionalMsg);
            if (phoneNumber.equals("0")) return;

            try {
                if (!clientService.isPhoneExists(phoneNumber)) {
                    break;
                } else {
                    System.out.println("Phone is already in use, try another one");
                }
            } catch (SQLException e) {
                System.out.println("Couldn't check phone existence, try again later.");
            }
        }

        try {
            clientService.createClient(firstName, secondName, email, phoneNumber);
        } catch (SQLException e) {
            System.out.println("sql exception");
        } catch (UserEmailAlreadyInUseException e) {
            System.out.println("email in use exception");
        } catch (UserPhoneNumberAlreadyInUseException e) {
            System.out.println("phone in use exception");
        }

        System.out.println("Returning to a previous menu page");
    }



    public void createBankAccount() {
        String phoneNumber;

        phoneNumber = inputHelper.getNonEmptyString("To create bank account for existing client please, provide client's phone number" + additionalMsg);
        if (phoneNumber.equals("0")) return;


        Client client;
        try {
            client = getClient(phoneNumber);
        } catch (SQLException e) {
            System.out.println("e = " + e);
            return;
        }

        if (client == null) {
            System.out.println("No client was found with that phone number.");
            return;
        } else {
            printHepler.printClientsInfo(client);
        }



        while(true) {
            System.out.println("Is this the client you're looking for?");
            System.out.println("1. Yes");
            System.out.println("2. No");

            int choice = inputHelper.getIntInput();

            if (choice == 2) {
                System.out.println("Try again then...");
                return;
            } else if (choice == 1) {
                System.out.println("Great, moving forward.");
                break;
            } else {
                System.out.println("Wrong choice.");
            }
        }

        Currency currency = Currency.EUR;
        while (true) {
            System.out.println("Please, choose currency:");
            System.out.println("1. EUR (default)");
            System.out.println("2. USD");
            System.out.println("3. BYN");
            System.out.println("0. Abort");

            int choice = inputHelper.getIntInput();
            if (choice == 0) return;

            switch (choice) {
                case 1: break;
                case 2: currency = Currency.USD; break;
                case 3: currency = Currency.BYN; break;
                default:
                    System.out.println("Wrong choice.");
            }

            if (choice >= 1 && choice <= 3) break;
        }

        //get result msg
        bankAccountService.createAccount(client.getId(), currency);
    }

    public void getClientsInfo(){
        String phoneNumber = inputHelper.getNonEmptyString("Please, provide a phone number" + additionalMsg);
        if (phoneNumber.equals("0")) {
            return;
        }
        try {
            Client client = getClient(phoneNumber);
            if (client == null) {
                System.out.println("No client was found with that phone number.");
                return;
            }
            printHepler.printClientsInfo(client);
        } catch (SQLException e){
            System.out.println(e.getErrorCode());
        }

    }


    public Client getClient(String phoneNumber) throws SQLException{
        return clientService.getClient(phoneNumber);
    }
}
