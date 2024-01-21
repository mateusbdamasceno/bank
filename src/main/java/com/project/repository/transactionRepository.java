
package com.project.repository;

import com.project.beans.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface transactionRepository {
    public List<Transaction> findAllTransactions();

    Transaction saveTransaction(Transaction transaction);
}
