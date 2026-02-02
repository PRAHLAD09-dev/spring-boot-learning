package com.prahlad.rest.controller;

import com.prahlad.rest.dto.ApiResponse;
import com.prahlad.rest.model.User;
import com.prahlad.rest.service.UserService;
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

    // CREATE USER
    @PostMapping
    public ApiResponse<User> createUser(@RequestBody User user) 
    {
        User saved = service.addUser(user);
        return new ApiResponse<>("success", "User created successfully", saved);
    }

    // GET ALL USERS
    @GetMapping
    public ApiResponse<List<User>> getAllUsers() 
    {
        return new ApiResponse<>("success", "User list fetched", service.getAllUsers());
    }

    // GET USER BY ID
    @GetMapping("/{id}")
    public ApiResponse<User> getUser(@PathVariable int id) 
    {
        User user = service.getUserById(id);

        if (user == null) 
        {
            return new ApiResponse<>("error", "User not found", null);
        }

        return new ApiResponse<>("success", "User fetched", user);
    }
}