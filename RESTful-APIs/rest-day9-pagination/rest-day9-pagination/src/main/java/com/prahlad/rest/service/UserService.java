package com.prahlad.rest.service;

import com.prahlad.rest.dto.*;
import com.prahlad.rest.exception.UserNotFoundException;
import com.prahlad.rest.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService 
{
    private final List<User> users = new ArrayList<>();
    private long idCounter = 1;

    public UserResponseDto create(UserRequestDto dto) 
    {
        User user = new User(
                idCounter++,
                dto.getName(),
                dto.getEmail(),
                null
        );

        users.add(user);
        return map(user);
    }
    
    public PageResponseDto<UserResponseDto> getUsers(
            int page, int size, String keyword) 
    {

        List<User> filtered = users;

        if (keyword != null && !keyword.isBlank()) 
        {
            filtered = users.stream()
                    .filter(u -> u.getName()
                            .toLowerCase()
                            .contains(keyword.toLowerCase()))
                    .collect(Collectors.toList());
        }

        int start = page * size;
        int end = Math.min(start + size, filtered.size());

        if (start >= filtered.size()) 
        {
            throw new UserNotFoundException("No users found");
        }

        List<UserResponseDto> content =
                filtered.subList(start, end)
                        .stream()
                        .map(this::map)
                        .toList();

        return new PageResponseDto<>(
                content,
                page,
                size,
                filtered.size(),
                (int) Math.ceil((double) filtered.size() / size)
        );
    }

    public UserResponseDto updateProfileImage(Long id, String imagePath) 
    {
        User user = users.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElseThrow(() ->
                        new UserNotFoundException("User not found"));

        user.setProfileImage(imagePath);
        return map(user);
    }

    private UserResponseDto map(User user) 
    {
        return new UserResponseDto(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getProfileImage()
        );
    }
}