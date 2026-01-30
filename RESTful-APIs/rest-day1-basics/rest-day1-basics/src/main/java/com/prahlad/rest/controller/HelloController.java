package com.prahlad.rest.controller;

import com.prahlad.rest.model.User;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class HelloController 
{

    // API 1 — Simple Text
    @GetMapping("/hello")
    public String hello() 
    {
        return "REST Day 1 Started Successfully!";
    }

    // API 2 — Java → JSON Object
    @GetMapping("/user")
    public User getUser() 
    {
        return new User(1, "Prahlad", "prahlad@gmail.com");
    }

    // API 3 — Custom JSON Output
    @GetMapping("/time")
    public Map<String, Object> getTime() 
    {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("time", LocalTime.now());
        return response;
    }
}