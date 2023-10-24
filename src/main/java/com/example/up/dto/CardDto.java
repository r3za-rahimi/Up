package com.example.up.dto;

import com.example.up.dto.AbstractDto;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class CardDto extends AbstractDto {

    @Pattern(regexp = "^[0-9]{16}" , message = "cardNumber.size")
    private String cardNumber;
    private Integer cvv2 ;
    private Date expireDate;
}
