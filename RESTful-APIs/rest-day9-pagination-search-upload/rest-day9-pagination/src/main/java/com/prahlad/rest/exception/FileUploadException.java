package com.prahlad.rest.exception;

@SuppressWarnings("serial")
public class FileUploadException extends RuntimeException 
{
    public FileUploadException(String message) 
    {
        super(message);
    }
}