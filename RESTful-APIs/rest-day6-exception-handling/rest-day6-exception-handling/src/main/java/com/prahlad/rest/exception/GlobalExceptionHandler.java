package com.prahlad.rest.exception;

import com.prahlad.rest.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler 
{

    // Validation error (400)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDto> handleValidation(MethodArgumentNotValidException ex) 
    {

        String msg = ex.getBindingResult()
                       .getFieldError()
                       .getDefaultMessage();

        ErrorResponseDto error = new ErrorResponseDto(
                400,
                "BAD_REQUEST",
                msg
        );

        return ResponseEntity.badRequest().body(error);
    }

    // User not found (404)
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleUserNotFound(UserNotFoundException ex) 
    {

        ErrorResponseDto error = new ErrorResponseDto(
                404,
                "NOT_FOUND",
                ex.getMessage()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}