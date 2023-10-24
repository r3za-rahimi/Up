package com.example.up.entity;

import com.example.up.entity.account.Account;
import com.example.up.entity.account.DealType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction extends AbstractEntity {

    private Date transactionDate;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id")
    private Account account;
    private Long amount;
    @Enumerated(EnumType.STRING)
    private DealType dealType;
    private String trackingCode;
}
