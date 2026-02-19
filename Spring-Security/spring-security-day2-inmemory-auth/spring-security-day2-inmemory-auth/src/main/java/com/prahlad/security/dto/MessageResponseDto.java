package com.prahlad.security.dto;

public class MessageResponseDto 
{

    private String message;

    public MessageResponseDto(String message) 
    {
        this.message = message;
    }

    public String getMessage() 
    {
        return message;
    }
}