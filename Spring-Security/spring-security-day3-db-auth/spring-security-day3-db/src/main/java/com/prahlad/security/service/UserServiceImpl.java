package com.prahlad.security.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.prahlad.security.dto.LoginRequestDto;
import com.prahlad.security.dto.ResetPasswordRequestDto;
import com.prahlad.security.dto.SignupRequestDto;
import com.prahlad.security.dto.UpdatePasswordRequestDto;
import com.prahlad.security.dto.UserResponseDto;
import com.prahlad.security.entity.User;
import com.prahlad.security.exception.BadRequestException;
import com.prahlad.security.exception.ResourceNotFoundException;
import com.prahlad.security.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService 
{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository repo, PasswordEncoder encoder) 
    {
        this.userRepository = repo;
        this.passwordEncoder = encoder;
    }

    @Override
    public UserResponseDto signup(SignupRequestDto dto) 
    {

        if (userRepository.existsByEmail(dto.email()))
        {
            throw new BadRequestException("Email already registered");
        }

        User user = new User();
        user.setName(dto.name());
        user.setEmail(dto.email());
        user.setPassword(passwordEncoder.encode(dto.password()));
        user.setRole("USER");

        User saved = userRepository.save(user);

        return mapToDto(saved);
    }

    @Override
    public UserResponseDto login(LoginRequestDto dto) 
    {

        User user = userRepository.findByEmail(dto.email())
                .orElseThrow(() -> new ResourceNotFoundException("Invalid credentials"));

        if (!passwordEncoder.matches(dto.password(), user.getPassword()))
        {
            throw new BadRequestException("Invalid credentials");
        }

        return mapToDto(user);
    }

    @Override
    public UserResponseDto getUserById(Long id) 
    {
        return userRepository.findById(id)
                .map(this::mapToDto)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    
    @Override
    public UserResponseDto updatePassword(Long userId, UpdatePasswordRequestDto dto) 
    {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        if (!passwordEncoder.matches(dto.getOldPassword(), user.getPassword()))
        {
            throw new BadRequestException("Old password is incorrect");
        }

        user.setPassword(passwordEncoder.encode(dto.getNewPassword()));

        User saved = userRepository.save(user);
        return mapToDto(saved);
    }
    
    @Override
    public void resetPassword(ResetPasswordRequestDto dto) 
    {

        User user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        user.setPassword(passwordEncoder.encode(dto.getNewPassword()));
        userRepository.save(user);
    }
    
    private UserResponseDto mapToDto(User user) 
    {
        return new UserResponseDto(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole()
        );
    }

}