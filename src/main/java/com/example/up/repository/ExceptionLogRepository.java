package com.example.up.repository;

import com.example.up.exceptionhandler.ExceptionLog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExceptionLogRepository extends MongoRepository<ExceptionLog , Long> {
}
