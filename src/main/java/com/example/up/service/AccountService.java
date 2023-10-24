package com.example.up.service;

import com.example.up.dto.CardDto;
import com.example.up.entity.Card;
import com.example.up.entity.account.Account;
import com.example.up.repository.AccountRepository;
import com.example.up.repository.CardRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService extends AbstractService<AccountRepository, Account>{


    public void addCartToAccount(Card card , Long userId){


        Account userAccount = repository.findByUser_Id(userId).orElseThrow(() -> new RuntimeException("User Not Found"));
        userAccount.setCard(card);

        repository.save(userAccount);

    }
}
