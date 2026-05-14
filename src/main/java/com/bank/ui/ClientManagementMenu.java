package com.bank.ui;

import com.bank.exception.UserEmailAlreadyInUseException;
import com.bank.exception.UserPhoneNumberAlreadyInUseException;
import com.bank.service.ClientService;
import com.bank.ui.helper.InputHelper;

import java.sql.SQLException;

public class ClientManagementMenu {
    private final ClientService clientService;
    private final InputHelper inputHelper;

    public ClientManagementMenu(ClientService clientService, InputHelper inputHelper) {
        this.clientService = clientService;
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
                    return;
                } else {
                    System.out.println("Email is already in use, try another one");
                    break;
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
                    return;
                } else {
                    System.out.println("Phone is already in use, try another one");
                    break;
                }
            } catch (SQLException e) {
                System.out.println("Couldn't check phone existence, try again later.");
            }

        }

        try {
            clientService.createClient(firstName, secondName, email, phoneNumber);
        } catch (SQLException e) {
            System.out.println(" ");
        } catch (UserEmailAlreadyInUseException e) {
            System.out.println("  ");
        } catch (UserPhoneNumberAlreadyInUseException e) {
            System.out.println("   ");
        }

        System.out.println("Returning to a previous menu page");
    }


}
