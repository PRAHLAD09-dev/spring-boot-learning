package com.prahlad.security.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.prahlad.security.dto.MessageResponseDto;

@RestControllerAdvice
public class GlobalExceptionHandler 
{

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MessageResponseDto> handleException(Exception ex) 
    {
        return new ResponseEntity<>(
                new MessageResponseDto(ex.getMessage()),
                HttpStatus.BAD_REQUEST
        );
    }
}