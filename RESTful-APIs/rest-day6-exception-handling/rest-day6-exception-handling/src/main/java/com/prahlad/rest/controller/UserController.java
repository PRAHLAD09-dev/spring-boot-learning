package com.prahlad.rest.controller;

import com.prahlad.rest.dto.UserRequestDto;
import com.prahlad.rest.dto.UserResponseDto;
import com.prahlad.rest.model.User;
import com.prahlad.rest.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController 
{

    private final UserService service;

    public UserController(UserService service) 
    {
        this.service = service;
    }

    // POST — create user
    @PostMapping
    public UserResponseDto createUser(@Valid @RequestBody UserRequestDto dto) 
    {

        User user = new User(
                dto.getId(),
                dto.getName(),
                dto.getEmail()
        );

        User saved = service.save(user);

        return new UserResponseDto(
                "SUCCESS",
                "USER CREATED SUCCESSFULLY",
                saved
        );
    }

    // GET — get by id
    @GetMapping("/{id}")
    public UserResponseDto getUser(@PathVariable int id) 
    {

        User user = service.getById(id);

        return new UserResponseDto(
                "SUCCESS",
                "USER FOUND",
                user
        );
    }
}