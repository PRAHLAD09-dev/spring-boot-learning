package com.prahlad.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prahlad.security.dto.MessageResponseDto;

@RestController
@RequestMapping("/api/admin")
public class AdminController 
{

    @GetMapping("/dashboard")
    public MessageResponseDto adminDashboard() 
    {
        return new MessageResponseDto("Admin Dashboard - ADMIN access only");
    }

    @GetMapping("/users")
    public MessageResponseDto manageUsers() 
    {
        return new MessageResponseDto("Admin can view/manage users");
    }

    @GetMapping("/reports")
    public MessageResponseDto systemReports() 
    {
        return new MessageResponseDto("System reports visible to ADMIN only");
    }
}