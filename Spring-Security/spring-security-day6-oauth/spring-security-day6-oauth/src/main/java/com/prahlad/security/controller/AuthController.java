package com.prahlad.security.controller;


import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController 
{

    @GetMapping("/")
    public String home()
    {
        return "Public Home Page";
    }

    @GetMapping("/profile")
    public Object profile(Authentication authentication) 
    {
        return authentication.getPrincipal();
    }
}