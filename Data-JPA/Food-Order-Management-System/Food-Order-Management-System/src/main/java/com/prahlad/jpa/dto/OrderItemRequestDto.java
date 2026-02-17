package com.prahlad.jpa.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record OrderItemRequestDto(

        @NotBlank(message = "Product name required")
        String productName,

        @Min(value = 1, message = "Quantity must be >= 1")
        int quantity

) {}