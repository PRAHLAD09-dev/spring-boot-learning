package com.prahlad.jpa.dto;

import java.util.List;

public record UserResponseDto(
	    Long id,
	    String name,
	    String email,
	    List<OrderResponseDto> orders
	) {}