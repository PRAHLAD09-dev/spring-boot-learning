package com.prahlad.rest.dto;

import java.time.LocalDateTime;

public class ErrorResponseDto {

    private int status;
    private String message;
    private LocalDateTime timestamp;

    public ErrorResponseDto(int status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}