package com.prahlad.security.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.prahlad.security.dto.LoginRequestDto;
import com.prahlad.security.dto.ResetPasswordRequestDto;
import com.prahlad.security.dto.SignupRequestDto;
import com.prahlad.security.dto.UpdatePasswordRequestDto;
import com.prahlad.security.dto.UserResponseDto;
import com.prahlad.security.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController 
{

    private final UserService userService;

    public AuthController(UserService service) 
    {
        this.userService = service;
    }

    @PostMapping("/signup")
    public ResponseEntity<UserResponseDto> signup(@Valid @RequestBody SignupRequestDto dto) 
    {

        return new ResponseEntity<>( userService.signup(dto),HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponseDto> login(@Valid @RequestBody LoginRequestDto dto) 
     {

        return ResponseEntity.ok(userService.login(dto));
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable Long id) 
    {
        return ResponseEntity.ok(userService.getUserById(id));
    }
    
    @PutMapping("/users/{id}/password")
    public ResponseEntity<UserResponseDto> updatePassword(
            @PathVariable Long id,
            @RequestBody UpdatePasswordRequestDto dto) 
    {

        return ResponseEntity.ok(userService.updatePassword(id, dto));
    }
    
    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword( @RequestBody ResetPasswordRequestDto dto) 
    {
        userService.resetPassword(dto);
        return ResponseEntity.ok("Password reset successful");
    }
}