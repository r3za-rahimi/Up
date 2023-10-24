package com.example.up.controller;

import com.example.up.dto.request.OperationDto;
import com.example.up.dto.TransactionDto;
import com.example.up.dto.request.TransactionDateRequest;
import com.example.up.entity.Transaction;
import com.example.up.exceptionhandler.ServiceException;
import com.example.up.service.TransactionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController extends  AbstractController<Transaction , TransactionDto , TransactionService> {


    @PostMapping("/transfer")
    public String doTransaction(@RequestBody OperationDto transactionDto) throws ServiceException {

        return service.resolveTransaction(transactionDto);
    }

    @PostMapping("/betweenDate")
    public List<TransactionDto> getTransactionBetweenDate(@RequestBody TransactionDateRequest transactionDateRequest){

        return converter.convertEntities(service.getTransactionBetweenDate(transactionDateRequest));
    }


}
