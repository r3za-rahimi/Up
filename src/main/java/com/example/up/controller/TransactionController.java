package com.example.up.controller;

import com.example.up.dto.TransactionDto;
import com.example.up.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping()
    public String doTransaction(@RequestBody TransactionDto transactionDto){

        return transactionService.doTransaction(transactionDto);
    }
}
