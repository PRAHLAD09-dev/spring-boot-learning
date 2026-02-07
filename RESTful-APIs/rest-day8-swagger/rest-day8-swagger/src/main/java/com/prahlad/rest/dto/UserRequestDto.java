package com.prahlad.rest.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRequestDto {

    @NotBlank(message = "Name must not be blank")
    @Size(min = 3, max = 20, message = "Name must be between 3 to 20 characters")
    private String name;

    @NotBlank(message = "Email must not be blank")
    @Email(message = "Email must be valid")
    private String email;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}