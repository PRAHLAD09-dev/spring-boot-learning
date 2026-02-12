package com.prahlad.jpa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prahlad.jpa.dto.UserRequestDto;
import com.prahlad.jpa.dto.UserResponseDto;
import com.prahlad.jpa.entity.User;
import com.prahlad.jpa.repository.UserRepository;

@Service
public class UserService 
{

    private final UserRepository repo;

    public UserService(UserRepository repo) 
    {
        this.repo = repo;
    }

    // CREATE
    public UserResponseDto create(UserRequestDto dto) 
    {
        User user = new User(
                  dto.getName(),
        		  dto.getEmail()
        		  );

        User saved = repo.save(user);

        return new UserResponseDto(
                saved.getId(),
                saved.getName(),
                saved.getEmail()
        );
    }
    
    // UPDATE USER
    public User updateUser(Long id, UserResponseDto dto) 
    {

        User existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        User updated = new User(
                existing.getId(),
                dto.getName(),
                dto.getEmail()
        );

        return repo.save(updated);
    
}

    // GET BY ID
    public UserResponseDto getById(Long id) 
    {
        User user = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return new UserResponseDto(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }

    // GET ALL
    public List<UserResponseDto> getAll() 
    {
        return repo.findAll()
                .stream()
                .map(u -> new UserResponseDto(
                        u.getId(),
                        u.getName(),
                        u.getEmail()))
                .toList();
    }

    // DELETE
    public void delete(Long id) 
    {
        repo.deleteById(id);
    }
}