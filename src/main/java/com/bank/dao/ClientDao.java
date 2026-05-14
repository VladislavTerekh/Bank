package com.bank.dao;

import com.bank.exception.UserEmailAlreadyInUseException;
import com.bank.exception.UserPhoneNumberAlreadyInUseException;
import com.bank.model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientDao {

    Connection connection;

    public ClientDao(Connection connection) {
        this.connection = connection;
    }


    public void saveNewClient(Client client)
            throws SQLException, UserEmailAlreadyInUseException, UserPhoneNumberAlreadyInUseException {
        try {
            String sql = "INSERT INTO Clients ( name, second_name, email, phone_number, client_id ) VALUES ( ? , ? , ? , ? , ? )";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, client.getFirstName());
            ps.setString(2, client.getSecondName());
            ps.setString(3, client.getEmail());
            ps.setString(4, client.getPhoneNumber());
            ps.setInt(5, client.getFirstName().hashCode() + client.getSecondName().hashCode() +
                    client.getEmail().hashCode() + client.getPhoneNumber().hashCode());
            ps.executeQuery();
        } catch (SQLException e) {
            System.out.println("...");
        }



    }



    public boolean isEmailExists(String email) throws SQLException {
        String sql = "SELECT EXISTS (SELECT 1 FROM Clients WHERE email = ?)";

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, email);

        ResultSet rs = ps.executeQuery();

        //rs.next() technically always true for SELECT EXISTS
        return rs.next() && rs.getBoolean(1);
    }

    public boolean isPhoneExists(String phoneNumber) throws SQLException {
        String sql = "SELECT EXISTS (SELECT 1 FROM Clients WHERE phone_number = ?";

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, phoneNumber);

        ResultSet rs = ps.executeQuery();

        //rs.next() technically always true for SELECT EXISTS
        return rs.next() && rs.getBoolean(1);
    }

}
