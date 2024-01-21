package com.project.repository;

import com.project.beans.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class transactionRepositoryImp implements transactionRepository {

    public List<Transaction> findAllTransactions()  {
        return null;
    }


    @Override
    public Transaction saveTransaction(Transaction transaction) {
        System.out.println("SAVE TRANSACTION REPOSITORY"+transaction);
        return null;
    }
}
