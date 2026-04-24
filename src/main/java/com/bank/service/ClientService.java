package com.bank.service;

import com.bank.dao.ClientDao;
import com.bank.exception.UserEmailAlreadyInUseException;
import com.bank.exception.UserPhoneNumberAlreadyInUseException;
import com.bank.model.Client;

import java.sql.PreparedStatement;

public class ClientService {

    private ClientDao clientDao;

    public ClientService(ClientDao clientDao) {
        this.clientDao = clientDao;
    }



    public void createClient(String firstName,
                             String secondName,
                             String email,
                             String phoneNumber) throws UserEmailAlreadyInUseException, UserPhoneNumberAlreadyInUseException {

        Client client = new Client(firstName, secondName, email, phoneNumber);

        // clientDao.saveNewClient(client);
    }

}
