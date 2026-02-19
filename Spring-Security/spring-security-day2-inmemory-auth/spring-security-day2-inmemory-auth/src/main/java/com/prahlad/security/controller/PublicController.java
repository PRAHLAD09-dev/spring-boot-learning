package com.prahlad.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.prahlad.security.dto.MessageResponseDto;

@RestController
@RequestMapping("/api/public")
public class PublicController 
{

    @GetMapping("/health")
    public MessageResponseDto healthCheck() 
    {
        return new MessageResponseDto( "Application is running");
    }

    @GetMapping("/info")
    public MessageResponseDto appInfo() 
    {
    	return new MessageResponseDto( "Spring Security In-Memory Authentication Demo");
    }
}