package com.prahlad.security.service;

import org.springframework.stereotype.Service;

import com.prahlad.security.entity.RefreshToken;
import com.prahlad.security.entity.User;

@Service
public interface RefreshTokenService
{

    RefreshToken createRefreshToken(Long userId);

    RefreshToken verify(String token);

    void deleteByUser(User user);
}