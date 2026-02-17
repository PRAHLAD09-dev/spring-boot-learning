package com.prahlad.jpa.dto;

import jakarta.validation.constraints.NotNull;

public record OrderStatusUpdateDto(
	    @NotNull String status
	) {}