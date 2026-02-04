package com.prahlad.rest.service;

import com.prahlad.rest.exception.UserNotFoundException;
import com.prahlad.rest.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService 
{

    private final List<User> users = new ArrayList<>();

    public User save(User user) 
    {
        users.add(user);
        return user;
    }

    public User getById(int id) 
    {
        return users.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElseThrow(() ->
                        new UserNotFoundException("User not found with id: " + id)
                );
    }
}