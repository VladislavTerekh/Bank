package com.bank.ui;

import com.bank.exception.UserEmailAlreadyInUseException;
import com.bank.exception.UserPhoneNumberAlreadyInUseException;
import com.bank.model.Client;
import com.bank.model.Currency;
import com.bank.service.BankAccountService;
import com.bank.service.ClientService;
import com.bank.service.TransactionService;
import com.bank.ui.helper.InputHelper;

import java.sql.SQLException;

public class ClientManagementMenu {
    private final ClientService clientService;
    private final BankAccountService bankAccountService;
    private final TransactionService transactionService;
    private final InputHelper inputHelper;

    public ClientManagementMenu(ClientService clientService, BankAccountService bankAccountService,
                                TransactionService transactionService, InputHelper inputHelper) {
        this.clientService = clientService;
        this.bankAccountService = bankAccountService;
        this.transactionService = transactionService;
        this.inputHelper = inputHelper;
    }




    public void createClient() {
        String additionalMsg = " / enter 0 to abort whole operation: ";

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
        Client client;

        //enter email, phone number or client ID
        while (true) {
            System.out.println("To create bank account for existing client please, chose option to provide: ");
            System.out.println("1. Enter phone number");
            System.out.println("2. Enter email");
            System.out.println("3. Enter client ID");
            System.out.println("0. Abort operation");

            int choice = inputHelper.getIntInput();

            if (choice == 0) return;

            switch (choice) {
                case 1: //enter phone, get result,
                    break;
                case 2: //enter email, get result
                    break;
                case 3: //enter client id, get result
                    break;
                default: System.out.println("Invalid choice!");
            }

            if (choice >= 1 && choice <=3) break;
        }


        client = getClientInfo();
        while(true) {
            System.out.println("Is this the client you're looking for?");
            System.out.println("1. Yes");
            System.out.println("2. No");

            int choice = inputHelper.getIntInput();

            if (choice == 2) {
                System.out.println("Try again then");
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
                case 1: currency = Currency.EUR; break;
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


    public Client getClientInfo() {

        //TODO: implement method
        return new Client(null, null, null, null, null);
    }
}
