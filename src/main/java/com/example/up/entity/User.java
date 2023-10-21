package com.example.up.entity;

import com.example.up.entity.account.Account;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class User extends AbstractEntity {


    private String userName;
    private String name;
    private String family;
    @OneToMany(mappedBy = "user" ,cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Account> account;

}
