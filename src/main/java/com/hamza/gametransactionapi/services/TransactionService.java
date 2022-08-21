package com.hamza.gametransactionapi.services;

import com.hamza.gametransactionapi.models.Transaction;
import com.hamza.gametransactionapi.repositories.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    private final TransactionRepo transactionRepo;

    @Autowired
    public TransactionService(TransactionRepo transactionRepo) {
        this.transactionRepo = transactionRepo;
    }


    public List<Transaction> getAllTransactions(){
        return transactionRepo.findAll();
    }

    public String saveTransaction(Transaction transaction){

        try{
            transactionRepo.save(transaction);
            return "Saved transaction to database successfully!";
        }catch (Exception e){

            e.printStackTrace();
            return "Error in saving the value";
        }

    }

    public ArrayList<Transaction> getTransactionsLessThan(BigDecimal amount) throws Exception{

        ArrayList<Transaction> matchingTransactions = transactionRepo.findByAmountLessThan(amount);

        if(matchingTransactions.isEmpty()){
            throw new Exception("There are no transactions less than or equal to " + amount + "!");
        }
        return matchingTransactions;
    }


    public ArrayList<Transaction> getTransactionsMoreThan(BigDecimal amount) throws Exception{

        ArrayList<Transaction> matchingTransactions = transactionRepo.findByAmountGreaterThan(amount);

        if(matchingTransactions.isEmpty()){
            throw new Exception("There are no transactions more than or equal to " + amount + "!");
        }
        return matchingTransactions;
    }


    public Transaction getTransactionById(Long id) throws Exception {

        Optional<Transaction> transactionOptional = transactionRepo.findById(id);

        if (transactionOptional.isEmpty()){
            throw new Exception("No transaction with id: " + id + " found!!");
        }
        return transactionOptional.get();
    }
}
