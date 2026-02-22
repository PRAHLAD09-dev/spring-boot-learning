package com.prahlad.security.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record SignupRequestDto(
		
		@Email String email,
	    @NotBlank String password,
	    @NotBlank String role
	    )
{
    
}