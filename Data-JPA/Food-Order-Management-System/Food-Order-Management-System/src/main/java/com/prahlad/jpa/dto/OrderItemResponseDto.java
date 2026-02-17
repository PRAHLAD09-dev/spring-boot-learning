package com.prahlad.jpa.dto;

public record OrderItemResponseDto(
        Long id,
        String productName,
        int quantity,
        double price
) {}