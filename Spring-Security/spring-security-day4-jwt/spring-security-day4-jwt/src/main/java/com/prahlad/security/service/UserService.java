package com.prahlad.security.service;

import org.springframework.stereotype.Service;

import com.prahlad.security.dto.ResetPasswordRequestDto;
import com.prahlad.security.dto.UserResponseDto;
import com.prahlad.security.dto.UserUpdateRequestDto;

@Service
public interface UserService 
{

    UserResponseDto getUserById(Long userId);

    UserResponseDto updateUser(Long userId, UserUpdateRequestDto dto);
    
    void resetPassword(Long userId, ResetPasswordRequestDto dto);
}