package com.bank.service;

import com.bank.dao.BankAccountDao;
import com.bank.model.Currency;

public class BankAccountService {

    private BankAccountDao bankAccountDao;

    public BankAccountService(BankAccountDao bankAccountDao) {
        this.bankAccountDao = bankAccountDao;
    }

    public void createAccount(String clientId, Currency currency) {
        bankAccountDao.createAccount(clientId, currency);
    }
}
