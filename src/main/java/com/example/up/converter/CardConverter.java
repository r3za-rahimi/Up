package com.example.up.converter;

import com.example.up.dto.CardDto;
import com.example.up.dto.UserDto;
import com.example.up.entity.Card;
import com.example.up.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CardConverter extends BaseConverter<Card, CardDto>{
}
