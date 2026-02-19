package com.prahlad.security.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prahlad.security.dto.MessageResponseDto;

@RestController
@RequestMapping("/api/user")
public class UserController 
{

    @GetMapping("/me")
    public MessageResponseDto currentUser(Principal principal) 
    {
        return new MessageResponseDto( "Logged in user: " + principal.getName());
    }

   
    @GetMapping("/dashboard")
    public MessageResponseDto userDashboard()
    {
        return new MessageResponseDto( "User Dashboard - Accessible by USER and ADMIN");
    }
}