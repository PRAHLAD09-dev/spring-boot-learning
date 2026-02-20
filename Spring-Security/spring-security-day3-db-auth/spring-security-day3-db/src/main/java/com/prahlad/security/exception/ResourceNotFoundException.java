package com.prahlad.security.exception;

@SuppressWarnings("serial")
public class ResourceNotFoundException extends RuntimeException 
{
    public ResourceNotFoundException(String msg) 
    {
        super(msg);
    }
}