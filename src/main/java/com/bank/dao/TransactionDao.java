package com.bank.dao;

import java.sql.Connection;

public class TransactionDao {

    Connection connection;

    public TransactionDao(Connection connection) {
        this.connection = connection;
    }
}
