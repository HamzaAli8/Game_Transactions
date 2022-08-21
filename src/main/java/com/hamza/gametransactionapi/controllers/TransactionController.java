package com.hamza.gametransactionapi.controllers;

import com.hamza.gametransactionapi.models.Transaction;
import com.hamza.gametransactionapi.services.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping(value = "/all")
    public List<Transaction> getAllTransaction(){
        return transactionService.getAllTransactions();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findTransactionById(@PathVariable Long id){
        try {
            Transaction transaction = transactionService.getTransactionById(id);
            return ResponseEntity.ok(transaction);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping(value = "/less")
    public ResponseEntity<?> findTransactionByAmountLessThan(@RequestParam("amount")BigDecimal amount){
        try {
            ArrayList<Transaction> transactions = transactionService.getTransactionsLessThan(amount);
            return ResponseEntity.ok(transactions);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping(value = "/more")
    public ResponseEntity<?> findTransactionByAmountMoreThan(@RequestParam("amount") BigDecimal amount){
        try {
            ArrayList<Transaction> transactions = transactionService.getTransactionsMoreThan(amount);
            return ResponseEntity.ok(transactions);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // complete find by user id method


    @PostMapping(value = "/save",consumes = "application/json", produces = "application/json")
    public String saveTransaction(@RequestBody Transaction transaction){
        return transactionService.saveTransaction(transaction);
    }

}
