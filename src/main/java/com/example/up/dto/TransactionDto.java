package com.example.up.dto;

import com.example.up.entity.User;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.util.Date;
@Data
public class TransactionDto {
    private Long senderId;

    private Long receiverId;
    private Long amount;

}
