package com.example.up.repository;

import com.example.up.entity.Transaction;
import com.example.up.entity.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {


    Optional<Account> findByUser_Id (Long userId);
}
