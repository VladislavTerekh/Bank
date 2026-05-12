package com.bank.ui;

import com.bank.service.ClientService;
import com.bank.ui.helper.InputHelper;

public class ClientManagementMenu {
    private final ClientService clientService;
    private final InputHelper inputHelper;

    public ClientManagementMenu(ClientService clientService, InputHelper inputHelper) {
        this.clientService = clientService;
        this.inputHelper = inputHelper;
    }

    public void createClient() {
        String firstName = inputHelper.getNonEmptyString("To create a new client, enter name / enter 0 to abort whole operation: ");
        if (firstName.equals("0")) return;
        String secondName = inputHelper.getNonEmptyString("Enter name / enter 0 to abort whole operation: ");
        if (secondName.equals("0")) return;

        // TODO: email check from DB (if exists) implemented with while cycle
        String email = inputHelper.getEmailAddress("Enter email / enter 0 to abort whole operation: ");
        if (email.equals("0")) return;

        // TODO: phoneNumber check from DB (if exists) implemented with while cycle
        String phoneNumber = inputHelper.getNonEmptyString("Enter phone number / enter 0 to abort whole operation: ");
        if (phoneNumber.equals("0")) return;

        clientService.createClient(firstName, secondName, email, phoneNumber);

        System.out.println("Returning to a previous menu page");
    }


}
