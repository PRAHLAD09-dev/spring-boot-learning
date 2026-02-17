package com.prahlad.jpa.service.UserService;


import org.springframework.stereotype.Service;
import com.prahlad.jpa.dto.UserRequestDto;
import com.prahlad.jpa.dto.UserResponseDto;


@Service
public interface UserService 
{
	// ================= USER CRUD =================
	
    UserResponseDto createUser(UserRequestDto dto);

    UserResponseDto getUserById(Long userId);

    UserResponseDto updateUser(Long userId, UserRequestDto dto);

    void deleteUser(Long userId);

}