package com.example.up.dto;

import com.example.up.entity.AbstractEntity;
import com.example.up.entity.Card;
import com.example.up.entity.Transaction;
import com.example.up.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto extends AbstractDto {

    private Long accountNumber;
    private Long balance;
    private Card card;
    private List<Transaction> transactions;
}
