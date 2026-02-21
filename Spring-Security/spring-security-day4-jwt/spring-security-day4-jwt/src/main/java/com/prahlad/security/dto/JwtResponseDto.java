package com.prahlad.security.dto;

public class JwtResponseDto 
{
    public String token;

    public JwtResponseDto(String token) 
    {
        this.token = token;
    }
}