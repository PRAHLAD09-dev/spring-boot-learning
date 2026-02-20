package com.prahlad.security.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record SignupRequestDto(
        @NotBlank String name,
        @Email String email,
        @NotBlank String password
) {}