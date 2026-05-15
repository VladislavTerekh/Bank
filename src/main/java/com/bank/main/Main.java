package com.bank.main;

import com.bank.dao.BankAccountDao;
import com.bank.dao.ClientDao;
import com.bank.dao.TransactionDao;
import com.bank.service.BankAccountService;
import com.bank.service.ClientService;
import com.bank.service.TransactionService;
import com.bank.ui.ConsoleMenu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Bank"; //security issue
        String user = "root"; //security issue
        String password = "9876543210"; //security issue

        try (Connection connection = DriverManager.getConnection(url, user, password)){

            ClientDao clientDao = new ClientDao(connection);
            ClientService clientService = new ClientService(clientDao);

            BankAccountDao bankAccountDao = new BankAccountDao(connection);
            BankAccountService bankAccountService = new BankAccountService(bankAccountDao);

            TransactionDao transactionDao = new TransactionDao(connection);
            TransactionService transactionService = new TransactionService(transactionDao);


            ConsoleMenu ui = new ConsoleMenu(clientService, bankAccountService, transactionService);


            System.out.println("Connection successful.");
            ui.start();

        } catch (SQLException e) {
            System.out.println("Couldn't connect to a DB.");
            throw new RuntimeException(e);
        }
    }
}
