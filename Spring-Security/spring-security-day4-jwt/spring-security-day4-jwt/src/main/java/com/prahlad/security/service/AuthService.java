package com.prahlad.security.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prahlad.security.dto.*;
import com.prahlad.security.entity.User;
import com.prahlad.security.repository.UserRepository;
import com.prahlad.security.security.JwtUtil;

@Service
@Transactional
public class AuthService 
{

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final JwtUtil jwtUtil;

    public AuthService(UserRepository userRepository,
                       PasswordEncoder encoder,
                       JwtUtil jwtUtil) 
    {
        this.userRepository = userRepository;
        this.encoder = encoder;
        this.jwtUtil = jwtUtil;
    }

    public void signup(SignupRequestDto dto) 
    {

        User user = new User();
        user.setEmail(dto.email());
        user.setPassword(encoder.encode(dto.password()));
        user.setRole(dto.role());

        userRepository.save(user);
    }

    public JwtResponseDto login(LoginRequestDto dto) 
    {

        User user = userRepository.findByEmail(dto.email())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        if (!encoder.matches(dto.password(), user.getPassword())) 
        {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtUtil.generateToken(user.getEmail());
        return new JwtResponseDto(token);
    }
}