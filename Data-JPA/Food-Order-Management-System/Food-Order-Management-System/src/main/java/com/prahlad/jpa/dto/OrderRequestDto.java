package com.prahlad.jpa.dto;

import java.util.List;


public record OrderRequestDto(
      
        List<OrderItemRequestDto> items
)
{}