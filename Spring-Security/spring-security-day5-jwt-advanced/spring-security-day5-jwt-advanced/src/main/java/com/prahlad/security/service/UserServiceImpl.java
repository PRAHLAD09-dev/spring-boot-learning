package com.prahlad.security.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prahlad.security.dto.*;
import com.prahlad.security.entity.User;
import com.prahlad.security.exception.BadRequestException;
import com.prahlad.security.exception.ResourceNotFoundException;
import com.prahlad.security.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // ================= GET USER =================
    @Override
    public UserResponseDto getUserById(Long id, Authentication auth) {

        String email = auth.getName();

        User loggedInUser = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        User requestedUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

     boolean   isAdmin = "ROLE_ADMIN".equals(loggedInUser.getRole());

        if (!isAdmin && !loggedInUser.getId().equals(requestedUser.getId())) {
            throw new BadRequestException("You can access only your own data");
        }

        return mapToResponse(requestedUser);
    }

    // ================= UPDATE USER =================
    @Override
    public UserResponseDto updateUser(
            Long userId,
            UserUpdateRequestDto dto,
            Authentication auth
    ) 
    {

        String email = auth.getName();

        User loggedInUser = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        boolean isAdmin = loggedInUser.getRole().equals("ROLE_ADMIN");

        if (!isAdmin && !loggedInUser.getId().equals(userId)) 
        {
            throw new BadRequestException("You can update only your own profile");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        if (dto.email() != null) {
            user.setEmail(dto.email());
        }

        if (dto.password() != null && !dto.password().isBlank()) 
        {
            user.setPassword(passwordEncoder.encode(dto.password()));
        }

        return mapToResponse(userRepository.save(user));
    }

    // ================= RESET PASSWORD =================
    @Override
    public void resetPassword(
            Long userId,
            ResetPasswordRequestDto dto,
            Authentication auth
    ) {

        String email = auth.getName();

        User loggedInUser = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        boolean isAdmin = loggedInUser.getRole().equals("ROLE_ADMIN");

        if (!isAdmin && !loggedInUser.getId().equals(userId)) {
            throw new BadRequestException("You can reset only your own password");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        user.setPassword(passwordEncoder.encode(dto.newPassword()));
        userRepository.save(user);
    }

    private UserResponseDto mapToResponse(User user) 
    {
        return new UserResponseDto(
                user.getId(),
                user.getEmail(),
                user.getRole()
        );
    }
}