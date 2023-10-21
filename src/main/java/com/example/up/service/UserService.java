package com.example.up.service;

import com.example.up.entity.User;
import com.example.up.entity.account.Account;
import com.example.up.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService  {

    @Autowired
    private UserRepository userRepository;


    public void insert(User user){

        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account((long) (Math.random() * 100000000000000L), 0L , user , null , Collections.EMPTY_LIST));

        user.setAccount(accounts);

        userRepository.save(user);
    }

    public User getUser(Long id){

      return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not Found"));

    }
}
