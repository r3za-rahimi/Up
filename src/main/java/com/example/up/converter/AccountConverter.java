package com.example.up.converter;

import com.example.up.dto.AbstractDto;
import com.example.up.dto.AccountDto;
import com.example.up.entity.account.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountConverter extends BaseConverter<Account, AccountDto>{
}
