package com.prahlad.rest.service;

import com.prahlad.rest.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService 
{

    private final List<User> users = new ArrayList<>();

    public User addUser(User user) 
    {
        users.add(user);
        return user;
    }

    public List<User> getAllUsers() 
    {
        return users;
    }
}