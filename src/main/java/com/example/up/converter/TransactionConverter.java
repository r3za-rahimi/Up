package com.example.up.converter;

import com.example.up.dto.TransactionDto;
import com.example.up.dto.UserDto;
import com.example.up.entity.Transaction;
import com.example.up.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionConverter extends BaseConverter<Transaction, TransactionDto>{
}
