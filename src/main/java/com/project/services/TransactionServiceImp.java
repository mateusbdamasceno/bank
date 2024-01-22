package com.project.services;

import com.project.beans.Transaction;
import com.project.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
public class TransactionServiceImp implements TransactionService {

    @Autowired
    public TransactionRepository repository;

    @Override
    public Transaction makeTransfer(Transaction transaction) throws Exception {

        System.out.println("transaction.getTransferDate(): "+transaction.getTransferDate());

        validate(transaction);

        transaction.setSchedulingDate(new Date());
        transaction.setRate(verify(calculeDifferenceDays(transaction.getTransferDate()), transaction.getValueTransfer()));

        return repository.save(transaction);
    }

    public void validate(Transaction transaction) throws Exception {
        if(transaction.getSourceAccount().length()>10 || transaction.getTargetAccount().length()>10){
            throw new Exception("CONTA INCORRETA OU INEXISTENTE.");
        }else{
            Optional.ofNullable(verify(calculeDifferenceDays(transaction.getTransferDate()), transaction.getValueTransfer()))
                    .orElseThrow(() -> new Exception("DATAS FORA DA MARGEM DE ACEITAÇÃO"));
        }
    }

    /**
     * @return
     */
    @Override
    public List<Transaction> getTransactions() {
        return null;
    }

    public long calculeDifferenceDays(Date date){
        long diffInMillies = Math.abs(new Date().getTime() - date.getTime());
        return TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }

    public BigDecimal verify(long differenceDays, BigDecimal value){
        System.out.println("differenceDays: "+differenceDays);
        if(differenceDays<0 || differenceDays>50){
            return null;
        }else{
            if(differenceDays==0){
                return new BigDecimal("3.0").add(value.multiply(new BigDecimal("0.025")));
            }else if(differenceDays<=10){
                return new BigDecimal("12.0");
            }else if(differenceDays<=20){
                return value.multiply(new BigDecimal("0.082"));
            }else if(differenceDays<=30){
                return value.multiply(new BigDecimal("0.069"));
            }else if(differenceDays<=40){
                return value.multiply(new BigDecimal("0.047"));
            }else if(differenceDays<=50){
                return value.multiply(new BigDecimal("0.017"));
            }
        }
        return value;
    }
}
