package com.prahlad.jpa.dto;

public record  AdminOrderItemResponseDto(
	        Long id,
	        String productName,
	        int quantity,
	        double price
	) {}

