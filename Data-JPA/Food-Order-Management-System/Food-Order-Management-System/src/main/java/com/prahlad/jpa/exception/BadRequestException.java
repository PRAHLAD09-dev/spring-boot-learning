package com.prahlad.jpa.exception;

@SuppressWarnings("serial")
public class BadRequestException extends RuntimeException 
{
    public BadRequestException(String msg) 
    {
        super(msg);
    }
}