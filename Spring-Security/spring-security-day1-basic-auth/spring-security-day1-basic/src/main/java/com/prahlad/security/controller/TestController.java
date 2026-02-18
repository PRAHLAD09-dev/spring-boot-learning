package com.prahlad.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController 
{

    @GetMapping("/public")
    public String publicApi()
    {
        return "Public API - No Security";
    }

    @GetMapping("/secure")
    public String secureApi()
    {
        return "Secure API - Login Required";
    }
}