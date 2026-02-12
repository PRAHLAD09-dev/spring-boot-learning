package com.prahlad.jpa.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prahlad.jpa.dto.UserRequestDto;
import com.prahlad.jpa.dto.UserResponseDto;
import com.prahlad.jpa.entity.User;
import com.prahlad.jpa.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController 
{

    private final UserService service;

    public UserController(UserService service) 
    {
        this.service = service;
    }

    @PostMapping
    public UserResponseDto create(@RequestBody UserRequestDto dto) 
    {
        return service.create(dto);
    }
    
    @PutMapping("/{id}")
    public User updateUser(
    		@PathVariable Long id, 
    		@RequestBody UserResponseDto dto) 
    {
		return service.updateUser(id, dto);

    }

    @GetMapping("/{id}")
    public UserResponseDto getById(@PathVariable Long id) 
    {
        return service.getById(id);
    }

    @GetMapping
    public List<UserResponseDto> getAll() 
    {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) 
    {
        service.delete(id);
        return "User deleted";
    }
}