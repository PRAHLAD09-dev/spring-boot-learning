package com.prahlad.rest.exception;

import com.prahlad.rest.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // USER NOT FOUND
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleUserNotFound(
            UserNotFoundException ex) {

        ErrorResponseDto error =
            new ErrorResponseDto(404, ex.getMessage());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // 🔥 VALIDATION ERROR
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDto> handleValidationError(
            MethodArgumentNotValidException ex) {

        String message = ex.getBindingResult()
                           .getFieldError()
                           .getDefaultMessage();

        ErrorResponseDto error =
            new ErrorResponseDto(400, message);

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}