package com.project.services;

import com.project.beans.Transaction;
import com.project.repository.transactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class transactionServiceImp implements transactionService {

    @Autowired
    public transactionRepository repository;

    public List<Transaction> getTransactions(){
       return repository.findAllTransactions();
    }

    @Override
    public Transaction makeTransfer(Transaction transaction) {
        return repository.saveTransaction(transaction);
    }


}
