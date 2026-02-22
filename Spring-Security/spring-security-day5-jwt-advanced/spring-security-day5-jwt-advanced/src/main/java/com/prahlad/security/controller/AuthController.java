package com.prahlad.security.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.prahlad.security.dto.*;
import com.prahlad.security.entity.RefreshToken;
import com.prahlad.security.security.JwtUtil;
import com.prahlad.security.service.AuthService;
import com.prahlad.security.service.RefreshTokenService;

@RestController
@RequestMapping("/api/auth")
public class AuthController 
{

    private final AuthService authService;
    private final RefreshTokenService refreshTokenService;
    private final JwtUtil jwtUtil;

    public AuthController(AuthService authService ,RefreshTokenService refreshTokenService ,JwtUtil jwtUtil)
    {
        this.authService = authService;
        this.refreshTokenService = refreshTokenService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/signup")
    public ResponseEntity<MessageResponseDto> signup(
            @RequestBody SignupRequestDto dto) {

        authService.signup(dto);
        return ResponseEntity.ok(
                new MessageResponseDto("User registered")
        );
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponseDto> login(
            @RequestBody LoginRequestDto dto) {

        return ResponseEntity.ok(authService.login(dto));
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtResponseDto> refresh(
            @RequestBody Map<String, String> req) {

        String refreshToken = req.get("refreshToken");

        RefreshToken token = refreshTokenService.verify(refreshToken);
        String newAccessToken = jwtUtil.generateToken(token.getUser().getEmail());

        return ResponseEntity.ok(
                new JwtResponseDto(newAccessToken, refreshToken)
        );
    }

  
    @PostMapping("/logout")
    public ResponseEntity<MessageResponseDto> logout(Authentication auth) {
        authService.logout(auth.getName());
        return ResponseEntity.ok(new MessageResponseDto("Logged out successfully"));
    }
}