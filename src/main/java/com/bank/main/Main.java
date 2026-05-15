package com.bank.main;

import com.bank.dao.ClientDao;
import com.bank.service.ClientService;
import com.bank.ui.ConsoleMenu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Bank";
        String user = "root";
        String password = "9876543210";

        try (Connection connection = DriverManager.getConnection(url, user, password)){

            ClientDao clientDao = new ClientDao(connection);
            ClientService clientService = new ClientService(clientDao);
            ConsoleMenu ui = new ConsoleMenu(clientService);
            System.out.println("Connection successful.");
            ui.start();

        } catch (SQLException e) {
            System.out.println("Couldn't connect to a DB.");
            throw new RuntimeException(e);
        }
    }
}
