package com.example.up.dto;

import com.example.up.entity.AbstractEntity;
import com.example.up.entity.account.Account;
import com.example.up.entity.account.DealType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class TransactionDto extends AbstractDto {

    private Date transactionDate;
    private Long amount;
    private DealType dealType;
    private String trackingCode;
}
