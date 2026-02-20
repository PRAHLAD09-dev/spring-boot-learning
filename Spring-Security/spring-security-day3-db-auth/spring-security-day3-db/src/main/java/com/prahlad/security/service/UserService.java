package com.prahlad.security.service;

import com.prahlad.security.dto.LoginRequestDto;
import com.prahlad.security.dto.ResetPasswordRequestDto;
import com.prahlad.security.dto.SignupRequestDto;
import com.prahlad.security.dto.UpdatePasswordRequestDto;
import com.prahlad.security.dto.UserResponseDto;

public interface UserService 
{

    UserResponseDto signup(SignupRequestDto dto);

    UserResponseDto login(LoginRequestDto dto);

    UserResponseDto getUserById(Long id);
    
    UserResponseDto updatePassword(Long userId, UpdatePasswordRequestDto dto);
    
    void resetPassword(ResetPasswordRequestDto dto);
    
}