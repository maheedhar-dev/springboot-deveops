package com.spring.devops.controller;

import com.spring.devops.exception.BusinessException;
import com.spring.devops.exception.CountryAlreadyExistsException;
import com.spring.devops.model.ErrorMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorMessage> handleBusinessException(BusinessException ex) {
        System.err.println("Business Exception: " + ex.getMessage());
        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), "Business logic error occurred,No Countries are found");
        return ResponseEntity.status(400).body(errorMessage);
    }

    @ExceptionHandler(CountryAlreadyExistsException.class)
    public ResponseEntity<ErrorMessage> handleCountryAlreadyExistsException(CountryAlreadyExistsException ex) {
        System.err.println("Country Already Exists Exception: " + ex.getMessage());
        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), "Country with the same name already exists");
        return ResponseEntity.status(409).body(errorMessage);
    }
}
