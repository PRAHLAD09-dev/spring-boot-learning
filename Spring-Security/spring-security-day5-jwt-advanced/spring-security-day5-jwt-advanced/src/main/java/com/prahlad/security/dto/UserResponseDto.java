package com.prahlad.security.dto;

public record UserResponseDto(
        Long id,
        String email,
        String role
) {}