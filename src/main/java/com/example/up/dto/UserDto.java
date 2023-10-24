package com.example.up.dto;

import com.example.up.entity.AbstractEntity;
import com.example.up.entity.account.Account;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UserDto extends AbstractDto {

    private String userName;
    private String name;
    private String family;
    private List<Account> account;

}
