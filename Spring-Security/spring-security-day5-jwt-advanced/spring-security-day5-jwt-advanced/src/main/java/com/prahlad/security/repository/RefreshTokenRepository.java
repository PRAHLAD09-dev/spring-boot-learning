package com.prahlad.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prahlad.security.entity.RefreshToken;
import com.prahlad.security.entity.User;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long>
{

  Optional<RefreshToken> findByToken(String token);

  void deleteByUser(User user);
}
