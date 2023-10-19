package com.example.up.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Data
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date transactionDate;
    @OneToOne
    private User sender;
    @OneToOne
    private User receiver;
    private Long amount;
    private String trackingCode;
}
