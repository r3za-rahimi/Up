package com.example.up.converter;

import com.example.up.dto.UserDto;
import com.example.up.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserConverter extends BaseConverter<User , UserDto>{
}
