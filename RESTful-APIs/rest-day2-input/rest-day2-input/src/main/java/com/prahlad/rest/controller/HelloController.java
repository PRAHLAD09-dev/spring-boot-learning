package com.prahlad.rest.controller;

import com.prahlad.rest.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HelloController 
{

    // POST API (JSON → Java)
    @PostMapping("/user")
    public User createUser(@RequestBody User user) 
    {
        user.setId(101);
        return user;
    }

    // Path Variable
    @GetMapping("/user/{name}")
    public String getUserByName(@PathVariable String name) 
    {
        return "Hello " + name;
    }

    // Query Parameter
    @GetMapping("/search")
    public String searchUser(@RequestParam String keyword) 
    {
        return "Searching for: " + keyword;
    }
}