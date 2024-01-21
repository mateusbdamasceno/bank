package com.project.services;

import com.project.beans.Transaction;
import com.project.repository.transactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.*;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
public class transactionServiceImp implements transactionService {

    @Autowired
    public transactionRepository repository;

    public List<Transaction> getTransactions(){
       return repository.findAllTransactions();
    }

    @Override
    public Transaction makeTransfer(Transaction transaction) {

        System.out.println("transaction.getTransferDate(): "+transaction.getTransferDate());

        transaction.setRate(verify(calculeDifferenceDays(transaction.getTransferDate()), transaction.getValue()));

        return repository.saveTransaction(transaction);
    }

    public long calculeDifferenceDays(Date date){
        long diffInMillies = Math.abs(new Date().getTime() - date.getTime());
        return TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }

    public BigDecimal verify(long differenceDays, BigDecimal value){
        System.out.println("differenceDays: "+differenceDays);
        if(differenceDays<0 || differenceDays>50){
            System.out.println("ERRO");
        }else{
            if(differenceDays==0){
                return new BigDecimal("3.0").add(value.multiply(new BigDecimal("0.025")));
            }else if(differenceDays>=1 && differenceDays<10){
                return new BigDecimal("3.0").add(value.multiply(new BigDecimal("0.025")));
            }
        }

        //Optional.ofNullable(differenceDays)
        //        .map()

        return null;
    }



}
