package com.prahlad.rest.controller;

import com.prahlad.rest.dto.ApiResponse;
import com.prahlad.rest.model.User;
import com.prahlad.rest.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController 
{

    private final UserService service;

    public UserController(UserService service) 
    {
        this.service = service;
    }

    // CREATE (VALIDATED)
    @PostMapping
    public ApiResponse<User> createUser(@Valid @RequestBody User user) 
    {
        User saved = service.addUser(user);
        return new ApiResponse<>("success", "User created successfully", saved);
    }

    // READ ALL
    @GetMapping
    public ApiResponse<List<User>> getAllUsers() 
    {
        return new ApiResponse<>("success", "Users fetched", service.getAllUsers());
    }
}