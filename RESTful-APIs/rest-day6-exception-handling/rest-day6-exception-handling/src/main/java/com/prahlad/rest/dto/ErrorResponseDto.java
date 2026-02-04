package com.prahlad.rest.dto;

import java.time.LocalDateTime;

public class ErrorResponseDto
{

    private LocalDateTime timestamp = LocalDateTime.now();
    private int status;
    private String error;
    private String message;

    public ErrorResponseDto(int status, String error, String message)
    {
        this.status = status;
        this.error = error;
        this.message = message;
    }

	public LocalDateTime getTimestamp() 
	{
		return timestamp;
	}

	public int getStatus() 
	{
		return status;
	}

	public String getError() 
	{
		return error;
	}

	public String getMessage() 
	{
		return message;
	}

}