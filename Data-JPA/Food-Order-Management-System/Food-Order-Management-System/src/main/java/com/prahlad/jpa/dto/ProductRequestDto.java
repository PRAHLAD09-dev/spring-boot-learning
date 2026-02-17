package com.prahlad.jpa.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record ProductRequestDto(
		@NotBlank
	     String name,
		@Positive
		double price
		) 
{}
