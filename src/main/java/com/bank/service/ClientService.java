package com.bank.service;

import com.bank.dao.ClientDao;
import com.bank.exception.UserEmailAlreadyInUseException;
import com.bank.exception.UserPhoneNumberAlreadyInUseException;
import com.bank.model.Client;
import com.bank.model.Currency;


import java.sql.SQLException;

public class ClientService {

    private final ClientDao clientDao;

    public ClientService(ClientDao clientDao) {
        this.clientDao = clientDao;
    }


    public void createClient(String firstName,
                             String secondName,
                             String email,
                             String phoneNumber)
            throws UserEmailAlreadyInUseException,
            UserPhoneNumberAlreadyInUseException,
            SQLException{

        Client client = new Client(firstName, secondName, email, phoneNumber);

        clientDao.saveNewClient(client);
    }

    public void createAccountForAClient(Client client, Currency currency) {

    }

    public boolean isEmailExists(String email) throws SQLException {
        return clientDao.isEmailExists(email);
    }

    public boolean isPhoneExists(String phoneNumber) throws SQLException{
        return clientDao.isPhoneExists(phoneNumber);
    }

}
