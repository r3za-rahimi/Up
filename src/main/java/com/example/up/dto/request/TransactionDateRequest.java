package com.example.up.dto.request;

import lombok.Data;

import java.util.Date;
@Data
public class TransactionDateRequest {

    private Date from;
    private Date to;

}
