package com.prahlad.security.controller;

import com.prahlad.security.dto.ResetPasswordRequestDto;
import com.prahlad.security.dto.UserResponseDto;
import com.prahlad.security.dto.UserUpdateRequestDto;
import com.prahlad.security.service.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController 
{

    private final UserService userService;

    public UserController(UserService userService)
    {
        this.userService = userService;
    }

 
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable Long id, Authentication auth) 
    {
        UserResponseDto response = userService.getUserById(id , auth);
        return ResponseEntity.ok(response);
    }

    
    @PutMapping("/{userId}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<UserResponseDto> updateUser(
            @PathVariable Long userId,
            @RequestBody UserUpdateRequestDto dto,
            Authentication auth) 
    {

        UserResponseDto response = userService.updateUser(userId, dto,auth);
        return ResponseEntity.ok(response);
    }

   
    @PutMapping("/{userId}/reset-password")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<String> resetPassword(
            @PathVariable Long userId,
            @RequestBody ResetPasswordRequestDto dto,
            Authentication auth) 
    {

        userService.resetPassword(userId, dto, auth);
        return ResponseEntity.ok("Password updated successfully");
    }
}