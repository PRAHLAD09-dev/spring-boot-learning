package com.prahlad.rest.controller;

import com.prahlad.rest.model.User;
import com.prahlad.rest.service.UserService;
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

    // CREATE
    @PostMapping
    public User createUser(@RequestBody User user) 
    {
        return service.addUser(user);
    }

    // READ ALL
    @GetMapping
    public List<User> getUsers() 
    {
        return service.getAllUsers();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) 
    {
        return service.getUserById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public User updateUser(@PathVariable int id,
                           @RequestBody User user) 
    {
        return service.updateUser(id, user);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) 
    {
        return service.deleteUser(id)
                ? "User deleted"
                : "User not found";
    }
}