package com.prahlad.jpa.controller;

import com.prahlad.jpa.entity.Order;
import com.prahlad.jpa.entity.User;
import com.prahlad.jpa.service.UserService;
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
    public User createUser(@RequestBody User user) 
    {
        return service.createUser(user);
    }

    @PostMapping("/{id}/orders")
    public User addOrder(
            @PathVariable Long id,
            @RequestBody Order order) 
    {
        return service.addOrder(id, order);
    }

    @GetMapping
    public List<User> getAllUsers() 
    {
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) 
    {
        return service.getById(id);
    }
    
    @DeleteMapping("/{userId}/orders/{orderId}")
    public User removeOrder(
            @PathVariable Long userId,
            @PathVariable Long orderId
    ) 
    {
        return service.removeOrder(userId, orderId);
    }
}