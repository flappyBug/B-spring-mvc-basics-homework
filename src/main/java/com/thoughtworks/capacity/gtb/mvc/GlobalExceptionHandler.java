package com.thoughtworks.capacity.gtb.mvc;

import com.thoughtworks.capacity.gtb.mvc.exception.RegisterException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RegisterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorResult handle(RegisterException exception) {
        return new ErrorResult(400, exception.getMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorResult handle(ConstraintViolationException exception) {
        return new ErrorResult(400, exception.getConstraintViolations().iterator().next().getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorResult handle(MethodArgumentNotValidException exception) {
        return new ErrorResult(400, exception.getBindingResult().getFieldError().getDefaultMessage());
    }
}
