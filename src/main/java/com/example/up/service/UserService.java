package com.example.up.service;

import com.example.up.entity.User;
import com.example.up.entity.account.Account;
import com.example.up.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService extends AbstractService<UserRepository , User> {
    @Override
    public User insert(User user){

        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account((long) (Math.random() * 100000000000000L), 500L , user , null , Collections.EMPTY_LIST));

        user.setAccount(accounts);

       return repository.save(user);
    }
    @Override
    public User getById(Long id){

      return repository.findById(id).orElseThrow(() -> new RuntimeException("User not Found"));

    }
}
