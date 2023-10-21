package com.example.up.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Data
@NoArgsConstructor
public class Card extends AbstractEntity {

    private String cardNumber;
    private Integer cvv2 ;
    private Date expireDate;
}
