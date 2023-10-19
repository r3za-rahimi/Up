package com.example.up.service;

import com.example.up.entity.User;
import com.example.up.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService  {

    @Autowired
    private UserRepository userRepository;


    public void insert(User user){

        userRepository.save(user);
    }

    public User getUser(Long id){

      return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not Found"));

    }
}
