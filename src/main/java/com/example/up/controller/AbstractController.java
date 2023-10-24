package com.example.up.controller;

import com.example.up.converter.BaseConverter;
import com.example.up.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class AbstractController  <E,D , S extends AbstractService<? extends JpaRepository<E, Long>, E> >{


    @Autowired
    protected S service;

    @Autowired
    protected BaseConverter<E, D> converter;



    @GetMapping()
    @Transactional
    public D get(Long id)  {
        return converter.convertEntity(service.getById(id));
    }
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public void add( @RequestBody D d)  {

        service.insert(converter.convertDto(d));
    }
}
