package com.hamza.gametransactionapi.repositories;

import com.hamza.gametransactionapi.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Long> {

    ArrayList<Transaction>  findByAmountLessThan(BigDecimal amount);
    ArrayList<Transaction>  findByAmountGreaterThan(BigDecimal amount);
}
