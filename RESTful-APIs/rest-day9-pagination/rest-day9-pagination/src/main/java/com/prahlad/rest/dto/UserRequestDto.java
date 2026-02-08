package com.prahlad.rest.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserRequestDto 
{

    @NotBlank
    private final String name;

    @Email
    @NotBlank
    private final String email;

    public UserRequestDto(String name, String email) 
    {
        this.name = name;
        this.email = email;
    }
    public String getName() 
    {
        return name;
    }
    public String getEmail() 
    {
        return email;
    }
}