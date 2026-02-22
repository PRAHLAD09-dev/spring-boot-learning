package com.prahlad.security.service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prahlad.security.entity.RefreshToken;
import com.prahlad.security.entity.User;
import com.prahlad.security.exception.BadRequestException;
import com.prahlad.security.repository.RefreshTokenRepository;
import com.prahlad.security.repository.UserRepository;

@Service
@Transactional
public class RefreshTokenServiceImpl implements RefreshTokenService {

    private static final long REFRESH_TOKEN_DURATION = 7 * 24 * 60 * 60; // 7 days

    private final RefreshTokenRepository refreshTokenRepository;
    private final UserRepository userRepository;

    public RefreshTokenServiceImpl(
            RefreshTokenRepository refreshTokenRepository,
            UserRepository userRepository) {

        this.refreshTokenRepository = refreshTokenRepository;
        this.userRepository = userRepository;
    }

    // ================= CREATE =================
    @Override
    public RefreshToken createRefreshToken(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        
        refreshTokenRepository.deleteByUser(user);

        RefreshToken token = new RefreshToken();
        token.setUser(user);
        token.setToken(UUID.randomUUID().toString());
        token.setExpiryDate(
                Instant.now().plus(REFRESH_TOKEN_DURATION, ChronoUnit.DAYS)
        );

        return refreshTokenRepository.save(token);
    }
    // ================= VERIFY =================
    @Override
    public RefreshToken verify(String token) 
    {

        RefreshToken refreshToken = refreshTokenRepository.findByToken(token)
                .orElseThrow(() -> new BadRequestException("Invalid refresh token"));

        if (refreshToken.getExpiryDate().isBefore(Instant.now()))
        {
            refreshTokenRepository.delete(refreshToken);
            throw new BadRequestException("Refresh token expired");
        }

        return refreshToken;
    }

    // ================= DELETE =================
    @Override
    public void deleteByUser(User user) 
    {
        refreshTokenRepository.deleteByUser(user);
    }
}