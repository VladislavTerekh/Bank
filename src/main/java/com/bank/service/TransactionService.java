package com.bank.service;

import com.bank.dao.TransactionDao;

public class TransactionService {

    private final TransactionDao transactionDao;

    public TransactionService(TransactionDao transactionDao) {
        this.transactionDao = transactionDao;
    }


}
