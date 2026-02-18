package com.prahlad.rest.exception;

@SuppressWarnings("serial")
public class UserNotFoundException extends RuntimeException 
{
    public UserNotFoundException(String message) 
    {
        super(message);
    }
}