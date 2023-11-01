package com.example.up.controller;

import com.example.up.dto.UserDto;
import com.example.up.entity.User;
import com.example.up.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController extends AbstractController<User , UserDto , UserService>{


    @PostMapping("/insert")
    public void insert(@RequestBody UserDto user){
        service.insert(converter.convertDto(user));
    }

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable("id") Long id){

      return  converter.convertEntity(service.getById(id));

    }

    @PutMapping
    public UserDto getUser(@RequestBody UserDto userDto){

        return  converter.convertEntity(service.updateUserName(userDto));

    }

    @DeleteMapping("/{id}")
    public void removeUser(@PathVariable("id") Long id){

          service.removeById(id);

    }
}
