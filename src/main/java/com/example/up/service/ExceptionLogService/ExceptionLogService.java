package com.example.up.service.ExceptionLogService;

import com.example.up.exceptionhandler.ExceptionLog;
import com.example.up.repository.ExceptionLogRepository;
import org.springframework.stereotype.Service;

@Service
public class ExceptionLogService {

    private final ExceptionLogRepository repository;

    public ExceptionLogService(ExceptionLogRepository repository) {
        this.repository = repository;
    }

    public void Insert(ExceptionLog log){

        repository.save(log);
    }
}
