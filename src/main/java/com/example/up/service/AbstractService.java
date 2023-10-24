package com.example.up.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public class AbstractService <R extends JpaRepository<E , Long> ,E>{


    @Autowired
    protected  R repository;


    public E insert(E e)  {
        return repository.save(e);
    }

    public E update(E e)  {
        return repository.save(e);
    }


    public E getById(Long id)  {
        //improve
        return repository.findById(id).get();
    }
}
