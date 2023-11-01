package com.example.up.service;

import com.example.up.dto.UserDto;
import com.example.up.entity.User;
import com.example.up.entity.account.Account;
import com.example.up.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService extends AbstractService<UserRepository , User> {
    @Override
    public User insert(User user){

//        List<Account> accounts = new ArrayList<>();
//        accounts.add(new Account((long) (Math.random() * 100000000000000L), 500L , user , null , Collections.EMPTY_LIST));
//
//        user.setAccount(accounts);

        user.getAccount().get(0).setUser(user);
       return repository.save(user);
    }
    @Cacheable(cacheNames = "USER_CACHE",key = "#id"  )
    @Override
    public User getById(Long id){

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return repository.findById(id).orElseThrow(() -> new RuntimeException("User not Found"));

    }

    @CachePut(cacheNames = "USER_CACHE",key = "#root.args[0].id" )
    public User updateUserName(UserDto userDto) {

        User user = getById(userDto.getId());
        user.setUserName(userDto.getUserName());

        return repository.save(user);
    }

    @CacheEvict(cacheNames = "USER_CACHE",key = "#id" )
    public void removeById(Long id){

         repository.deleteById(id);

    }
}
