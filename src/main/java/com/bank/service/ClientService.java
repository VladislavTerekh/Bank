package com.bank.service;

import com.bank.exception.UserEmailAlreadyInUseException;
import com.bank.exception.UserPhoneNumberAlreadyInUseException;
import com.bank.model.Client;

import java.sql.PreparedStatement;

public class ClientService {

    private Client client;

    public ClientService(Client client) {
        this.client = client;
    }



    public void CreateClient() throws UserEmailAlreadyInUseException, UserPhoneNumberAlreadyInUseException {
        if (false) {
            //user email check
            throw new UserEmailAlreadyInUseException("Email already exists in a Database");
        }
        if (false) {
            //user phone check
            throw new UserPhoneNumberAlreadyInUseException("Phone number already exists in a Database");
        }

        //PreparedStatement
    }

}
