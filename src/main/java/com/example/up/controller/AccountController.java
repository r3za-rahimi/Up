package com.example.up.controller;

import com.example.up.converter.CardConverter;
import com.example.up.dto.AccountDto;
import com.example.up.dto.CardDto;
import com.example.up.entity.Card;
import com.example.up.entity.account.Account;
import com.example.up.service.AccountService;
import com.example.up.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController extends  AbstractController<Account, AccountDto, AccountService> {
    @Autowired
    CardConverter cardConverter ;
    @PostMapping("/addCard/{id}")
    public void addCardToAccount(@RequestBody @Validated  CardDto cardDto , @PathVariable Long id){

        service.addCartToAccount(cardConverter.convertDto(cardDto) , id);

    }


}
