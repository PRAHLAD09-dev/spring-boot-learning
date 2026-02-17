package com.prahlad.jpa.dto;

import java.util.List;

public record OrderResponseDto(
        Long id,
        String status,
        Long userId,
        List<OrderItemResponseDto> items
) {}