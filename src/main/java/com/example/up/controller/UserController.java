package com.example.up.controller;

import com.example.up.entity.User;
import com.example.up.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/insert")
    public void insert(@RequestBody User user){
        userService.insert(user);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Long id){

      return   userService.getUser(id);

    }
}
