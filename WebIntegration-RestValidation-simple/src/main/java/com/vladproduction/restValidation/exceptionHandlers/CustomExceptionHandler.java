package com.vladproduction.restValidation.exceptionHandlers;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.Set;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> validationHandleException(
            MethodArgumentNotValidException methodArgumentNotValidException){
        List<ObjectError> allErrors = methodArgumentNotValidException.getAllErrors();
        String errorMessage = "";
        if(!allErrors.isEmpty()){
            StringBuilder sb = new StringBuilder();
            allErrors.forEach(objectError -> sb.append(objectError.getDefaultMessage()).append("\n"));
            errorMessage = sb.toString();
        }
        return ResponseEntity.ok(errorMessage);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> validationHandleException(
            ConstraintViolationException constraintViolationException){
        Set<ConstraintViolation<?>> constraintViolations = constraintViolationException.getConstraintViolations();
        String errorMessage = "";
        if(!constraintViolations.isEmpty()){
            StringBuilder sb = new StringBuilder();
            constraintViolations
                    .forEach(constraintViolation -> sb.append(constraintViolation.getMessage()).append("\n"));
            errorMessage = sb.toString();
        }
        return ResponseEntity.ok(errorMessage);
    }

}
