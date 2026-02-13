package com.prahlad.jpa.controller;


import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prahlad.jpa.dto.UserResponseDto;
import com.prahlad.jpa.service.UserService;



@RestController
@RequestMapping("/api/users")
public class UserController 
{

    private final UserService service;
    
    public UserController(UserService service)
    {
    	this.service = service;
    }

    @GetMapping
    public Page<UserResponseDto> getUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "name") String sortBy
    ) 
    {
        return service.getUsers(page, size, sortBy);
    }
}