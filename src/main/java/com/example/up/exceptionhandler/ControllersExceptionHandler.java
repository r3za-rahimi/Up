package com.example.up.exceptionhandler;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@ControllerAdvice
public class ControllersExceptionHandler {
    private static final String[] LOCALES = {"EN", "FA"};
    private final Map<String, Properties> propertiesMap = new HashMap<>();

    @PostConstruct
    public void init() throws IOException {
        for (String locale : LOCALES) {
            Properties properties = new Properties();
            try (InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("exceptions_" + locale + ".properties");
                 InputStreamReader in = new InputStreamReader(inputStream, "utf-8");) {
                properties.load(in);
                propertiesMap.put(locale, properties);
            }
        }
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ExceptionDto handle(MethodArgumentNotValidException exception, HttpServletRequest request) {

        String locale = request.getHeader("locale");

        Properties properties = this.propertiesMap.get(locale);
        if (properties == null) {
            properties = this.propertiesMap.get("FA");
        }
        String errorKey =  exception.getBindingResult().getFieldError().getDefaultMessage();

        Object translate = properties.get(errorKey);
        if (translate == null) {
            translate = properties.get(Exception.class.getName());
        }
        return ExceptionDto.builder()
                .errorCode(700)
                .message(String.valueOf(translate))
                .timestamp(new Date())
                .build();
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ExceptionDto handles(ConstraintViolationException exception, HttpServletRequest request) {

        String locale = request.getHeader("locale");

        Properties properties = this.propertiesMap.get(locale);
        if (properties == null) {
            properties = this.propertiesMap.get("FA");
        }
        String errorKey =  exception.getConstraintViolations().stream().toList().get(0).getMessageTemplate();

        Object translate = properties.get(errorKey);
        if (translate == null) {
            translate = properties.get(Exception.class.getName());
        }
        return ExceptionDto.builder()
                .errorCode(600)
                .message(String.valueOf(translate))
                .timestamp(new Date())
                .build();
    }

    @ExceptionHandler(ServiceException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ExceptionDto handles(ServiceException exception, HttpServletRequest request) {

        String locale = request.getHeader("locale");

        Properties properties = this.propertiesMap.get(locale);
        if (properties == null) {
            properties = this.propertiesMap.get("FA");
        }
        String errorKey =  exception.getErrorCode();

        Object translate = properties.get(errorKey);
        if (translate == null) {
            translate = properties.get(Exception.class.getName());
        }
        return ExceptionDto.builder()
                .errorCode(800)
                .message(String.valueOf(translate))
                .timestamp(new Date())
                .build();
    }
}