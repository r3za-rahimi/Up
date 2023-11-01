package com.example.up.entity;

import com.example.up.entity.account.Account;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class User extends AbstractEntity {


    private String userName;
    private String name;
    private String family;
    @OneToMany(mappedBy = "user" ,cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Account> account;

}
