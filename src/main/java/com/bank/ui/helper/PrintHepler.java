package com.bank.ui.helper;

import com.bank.model.Client;

public class PrintHepler {
    public void printClientsInfo(Client client){
        System.out.println("ID: " + client.getId());
        System.out.println("NAME: " + client.getFirstName());
        System.out.println("SECOND NAME: " + client.getSecondName());
        System.out.println("EMAIL: " + client.getEmail());
        System.out.println("PHONE: " + client.getPhoneNumber());
    }
}
