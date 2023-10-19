package com.example.up.service;

import com.example.up.dto.TransactionDto;
import com.example.up.entity.Transaction;
import com.example.up.entity.User;
import com.example.up.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private UserService userService;


    public String doTransaction(TransactionDto transactionDto){

        User sender = userService.getUser(transactionDto.getSenderId());
        Long senderBalance = sender.getCard().getBalance();
        if ( senderBalance < transactionDto.getAmount()){

            throw new RuntimeException("Khatttaaa");
        }
        sender.getCard().setBalance(senderBalance - transactionDto.getAmount());
        userService.insert(sender);

        User receiver = userService.getUser(transactionDto.getReceiverId());

        receiver.getCard().setBalance(receiver.getCard().getBalance() + transactionDto.getAmount());
        userService.insert(receiver);

        Transaction transaction = new Transaction();
        transaction.setSender(sender);
        transaction.setReceiver(receiver);
        transaction.setAmount(transactionDto.getAmount());
        transaction.setTransactionDate(new Date());
        transaction.setTrackingCode(UUID.randomUUID().toString());

        transactionRepository.save(transaction);

        return null;

    }

}
