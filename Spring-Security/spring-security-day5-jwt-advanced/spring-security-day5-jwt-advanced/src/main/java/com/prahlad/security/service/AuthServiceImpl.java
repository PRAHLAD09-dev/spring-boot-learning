package com.prahlad.security.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.prahlad.security.dto.*;
import com.prahlad.security.entity.RefreshToken;
import com.prahlad.security.entity.User;
import com.prahlad.security.exception.BadRequestException;
import com.prahlad.security.repository.UserRepository;
import com.prahlad.security.security.JwtUtil;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final RefreshTokenService refreshTokenService;

    public AuthServiceImpl(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            JwtUtil jwtUtil,
            RefreshTokenService refreshTokenService
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
        this.refreshTokenService = refreshTokenService;
    }

    // ================= SIGNUP =================
    @Override
    public void signup(SignupRequestDto dto) {

        if (userRepository.findByEmail(dto.email()).isPresent()) {
            throw new BadRequestException("Email already registered");
        }
        User user = new User();
        user.setEmail(dto.email());
        user.setPassword(passwordEncoder.encode(dto.password()));

        String role = dto.role();

        if (role == null || role.isBlank()) {
            role = "ROLE_USER";
        } else if (!role.startsWith("ROLE_")) {
            role = "ROLE_" + role;
        }

        user.setRole(role);
        userRepository.save(user);
    }

    // ================= LOGIN =================
    @Override
    public JwtResponseDto login(LoginRequestDto dto) {

        if (dto == null || dto.email() == null || dto.password() == null) {
            throw new BadRequestException("Email or password missing");
        }

        User user = userRepository.findByEmail(dto.email())
                .orElseThrow(() -> new BadRequestException("Invalid credentials"));

        if (!passwordEncoder.matches(dto.password(), user.getPassword())) {
            throw new BadRequestException("Invalid credentials");
        }

        String accessToken = jwtUtil.generateToken(user.getEmail());
        RefreshToken refreshToken =
                refreshTokenService.createRefreshToken(user.getId());

        return new JwtResponseDto(accessToken, refreshToken.getToken());
    }

    // ================= REFRESH =================
    @Override
    public JwtResponseDto refreshToken(String refreshToken) {

        RefreshToken token = refreshTokenService.verify(refreshToken);
        User user = token.getUser();

        String newAccessToken = jwtUtil.generateToken(user.getEmail());

        return new JwtResponseDto(
                newAccessToken,
                refreshToken
        );
    }

    // ================= LOGOUT =================
    @Override
    public void logout(String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new BadRequestException("User not found"));

        refreshTokenService.deleteByUser(user);
    }
}