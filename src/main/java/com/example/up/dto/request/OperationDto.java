package com.example.up.dto.request;

import lombok.Data;

@Data
public class OperationDto {
    private Long senderAccountId;
    private Long receiverAccountId;
    private Long amount;

}
