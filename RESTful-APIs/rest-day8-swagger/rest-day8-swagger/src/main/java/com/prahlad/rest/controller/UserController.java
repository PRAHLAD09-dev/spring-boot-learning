package com.prahlad.rest.controller;

import com.prahlad.rest.dto.UserRequestDto;
import com.prahlad.rest.dto.UserResponseDto;
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

    @PostMapping
    public UserResponseDto createUser(
            @Valid @RequestBody UserRequestDto dto) 
    {
        return service.createUser(dto);
    }

    @GetMapping
    public List<UserResponseDto> getAllUsers() 
    {
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserResponseDto getUser(@PathVariable int id) 
    {
        return service.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) 
    {
        service.deleteUser(id);
        return "User deleted successfully";
    }
}