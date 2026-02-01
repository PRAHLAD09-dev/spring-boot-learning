package com.prahlad.rest.service;

import com.prahlad.rest.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService 
{

    private List<User> users = new ArrayList<>();

    // CREATE
    public User addUser(User user) 
    {
        users.add(user);
        return user;
    }

    // READ ALL
    public List<User> getAllUsers() 
    {
        return users;
    }

    // READ BY ID
    public User getUserById(int id) 
    {
        return users.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // UPDATE
    public User updateUser(int id, User updatedUser) 
    {
        User user = getUserById(id);
        if (user != null) {
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
        }
        return user;
    }

    // DELETE
    public boolean deleteUser(int id) {
        return users.removeIf(u -> u.getId() == id);
    }
}