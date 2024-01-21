package com.project.controllers;

import com.project.beans.Transaction;
import com.project.services.transactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class transactionController {

    @Autowired
    public transactionService service;

    @GetMapping("/transactions")
    public List<Transaction> getTransactions(){
        return this.service.getTransactions();
    }

    @RequestMapping(value = "/transaction", method =  RequestMethod.POST)
    public Transaction transfer(@RequestBody Transaction transaction) throws Exception {
        return this.service.makeTransfer(transaction);
    }

    @RequestMapping("/")
    public String home(){
        return "Hello World!";
    }
}
