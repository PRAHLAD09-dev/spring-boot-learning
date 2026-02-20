package com.prahlad.security.dto;

public record UserResponseDto(
        Long id,
        String name,
        String email,
        String role
) {}