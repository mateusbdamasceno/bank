package com.project.services;

import com.project.beans.Transaction;

import java.util.List;

public interface transactionService {
    public List<Transaction> getTransactions();

    Transaction makeTransfer(Transaction transaction);

}
