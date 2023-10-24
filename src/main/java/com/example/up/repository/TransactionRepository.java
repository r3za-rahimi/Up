package com.example.up.repository;

import com.example.up.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction , Long> {


    List<Transaction> findByTransactionDateBetween(Date From , Date to);
}
