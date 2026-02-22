package com.prahlad.security.dto;

public record JwtResponseDto(
		String accessToken,
	    String refreshToken
	    ) {

}