package com.project.services;

import com.project.beans.Transaction;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface transactionService {
    public List<Transaction> getTransactions();

    Transaction makeTransfer(Transaction transaction) throws Exception;

    public long calculeDifferenceDays(Date date);

    public BigDecimal verify(long differenceDays, BigDecimal value);

    public void validate(Transaction transaction) throws Exception;

}
