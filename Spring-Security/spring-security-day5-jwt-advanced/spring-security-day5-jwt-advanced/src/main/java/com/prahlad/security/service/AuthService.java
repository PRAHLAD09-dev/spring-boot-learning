package com.prahlad.security.service;


import com.prahlad.security.dto.JwtResponseDto;
import com.prahlad.security.dto.LoginRequestDto;
import com.prahlad.security.dto.SignupRequestDto;

public interface AuthService
{

    void signup(SignupRequestDto dto);

    JwtResponseDto login(LoginRequestDto dto);

    JwtResponseDto refreshToken(String refreshToken);

	void logout(String email);
}