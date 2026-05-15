package com.bank.dao;

import com.bank.model.Currency;

import java.sql.Connection;

public class BankAccountDao {

    Connection connection;

    public BankAccountDao(Connection connection) {
        this.connection = connection;
    }

    public void createAccount(String clientId, Currency currency) {
        //TODO: implement method
    }
}
