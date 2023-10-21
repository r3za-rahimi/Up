package com.example.up.entity.account;

import com.example.up.entity.AbstractEntity;
import com.example.up.entity.Card;
import com.example.up.entity.Transaction;
import com.example.up.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account extends AbstractEntity {

    private Long accountNumber;
    private Long balance;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
    @OneToOne(targetEntity = Card.class,cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Card card;
    @OneToMany(mappedBy = "account",targetEntity = Transaction.class ,cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    private List<Transaction> transactions;
}
