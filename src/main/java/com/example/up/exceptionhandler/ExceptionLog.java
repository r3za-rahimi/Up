package com.example.up.exceptionhandler;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;

@Document
@Data
@Builder
public class ExceptionLog {

    @MongoId
    private String id;
    private String methodName;
    private Date dateTime;
    private String errormessage;

}
