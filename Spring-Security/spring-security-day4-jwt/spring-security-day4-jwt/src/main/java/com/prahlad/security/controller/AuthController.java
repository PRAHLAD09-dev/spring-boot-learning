package com.prahlad.security.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.prahlad.security.dto.*;
import com.prahlad.security.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController 
{

    private final AuthService authService;

    public AuthController(AuthService authService) 
    {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequestDto dto) 
    {
        authService.signup(dto);
        return ResponseEntity.ok(new MessageResponseDto("User registered"));
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponseDto> login(@RequestBody LoginRequestDto dto) 
    {
        return ResponseEntity.ok(authService.login(dto));
    }
}