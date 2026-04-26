package com.bank.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        //create Connection
        //create ClientDAO
        //create ClientService

        String url = """
                jdbc:mysql://localhost:3306/Bank\
                ?useSSL=false
                &serverTimezone=UTC
                &allowPublicKeyRetrieval=true
                &useUnicode=true
                &characterEncoding=UTF-8""";
        String user = "root";
        String password = "1234";

        try (Connection conn = DriverManager.getConnection(url, user, password)){

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
