package com.example.up.service;

import com.example.up.dto.request.OperationDto;
import com.example.up.dto.request.TransactionDateRequest;
import com.example.up.entity.Transaction;
import com.example.up.entity.account.Account;
import com.example.up.entity.account.DealType;
import com.example.up.exceptionhandler.ServiceException;
import com.example.up.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class TransactionService extends AbstractService<TransactionRepository, Transaction> {

    @Autowired
    private AccountService accountService;

    @Transactional
    public String resolveTransaction(OperationDto operation) throws ServiceException {


        String trackingCode = UUID.randomUUID().toString();
        withdraw(operation, trackingCode);
        deposit(operation, trackingCode);

        return trackingCode;

    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void withdraw(OperationDto operation, String trackingCode) throws ServiceException {

        Account sender = accountService.getById(operation.getSenderAccountId());
        Long senderBalance = sender.getBalance();
        if (senderBalance < operation.getAmount()) {

            throw new ServiceException("Balance.low");
        }
        sender.setBalance(senderBalance - operation.getAmount());
        List<Transaction> senderTransactions = sender.getTransactions();
        senderTransactions.add(Transaction
                .builder()
                .transactionDate(new Date())
                .trackingCode(trackingCode)
                .dealType(DealType.WITHDRAW)
                .amount(operation.getAmount())
                .account(sender)
                .build());
        sender.setTransactions(senderTransactions);

        accountService.insert(sender);
    }
    @Transactional(propagation = Propagation.SUPPORTS)
    public void deposit(OperationDto operation, String trackingCode) throws ServiceException {

        Account receiver = accountService.getById(operation.getReceiverAccountId());

        receiver.setBalance(receiver.getBalance() + operation.getAmount());
        accountService.insert(receiver);

        List<Transaction> receiverTransactions = receiver.getTransactions();
        receiverTransactions.add(Transaction
                .builder()
                .transactionDate(new Date())
                .trackingCode(trackingCode)
                .dealType(DealType.DEPOSIT)
                .amount(operation.getAmount())
                .account(receiver)
                .build());
        receiver.setTransactions(receiverTransactions);
        accountService.insert(receiver);

    }


    public List<Transaction> getTransactionBetweenDate(TransactionDateRequest transactionDateRequest) {

        return repository.findByTransactionDateBetween(transactionDateRequest.getFrom(), transactionDateRequest.getTo());
    }

}
