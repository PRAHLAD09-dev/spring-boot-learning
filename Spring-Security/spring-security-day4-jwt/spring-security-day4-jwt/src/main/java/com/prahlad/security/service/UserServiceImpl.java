package com.prahlad.security.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prahlad.security.dto.ResetPasswordRequestDto;
import com.prahlad.security.dto.UserResponseDto;
import com.prahlad.security.dto.UserUpdateRequestDto;
import com.prahlad.security.entity.User;
import com.prahlad.security.exception.ResourceNotFoundException;
import com.prahlad.security.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService 
{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository , PasswordEncoder passwordEncoder) 
    {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // ================= GET USER =================
    @Override
    public UserResponseDto getUserById(Long userId)
    {

        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found with id: " + userId)
                );

        return mapToResponse(user);
    }

    // ================= UPDATE USER =================
    @Override
	public UserResponseDto updateUser(Long userId, UserUpdateRequestDto dto) {
		User user = userRepository.findById(userId)
              .orElseThrow(() -> new ResourceNotFoundException("User not found"));

      if (dto.email() != null) {
          user.setEmail(dto.email());
      }

      // 🔥 PASSWORD UPDATE (SAFE)
      if (dto.password() != null && !dto.password().isBlank()) {
          user.setPassword(passwordEncoder.encode(dto.password()));
      }

      User savedUser = userRepository.save(user);
      return mapToResponse(savedUser);
  }
	
	@Override
	public void resetPassword(Long userId, ResetPasswordRequestDto dto) {

      User user = userRepository.findById(userId)
              .orElseThrow(() -> new ResourceNotFoundException("User not found"));

      user.setPassword(passwordEncoder.encode(dto.newPassword()));
      userRepository.save(user);
		
	}
    
    // ================= MAPPER =================
    private UserResponseDto mapToResponse(User user) 
    {

        return new UserResponseDto(
                user.getId(),
                user.getEmail(),
                user.getRole()
        );
    }

	
}