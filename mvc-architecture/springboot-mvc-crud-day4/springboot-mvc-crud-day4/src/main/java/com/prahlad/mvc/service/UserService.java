package com.prahlad.mvc.service;

import com.prahlad.mvc.model.User;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UserService 
{

    private List<User> users = new ArrayList<>();
    private int counter = 1;

    public void addUser(User user) 
    {
        user.setId(counter++);
        users.add(user);
    }

    public List<User> getAllUsers() 
    {
        return users;
    }

    public User getById(int id) 
    {
        return users.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void updateUser(User updated) 
    {
        User user = getById(updated.getId());
        if (user != null) {
            user.setName(updated.getName());
            user.setEmail(updated.getEmail());
        }
    }

    public void deleteUser(int id) 
    {
        users.removeIf(u -> u.getId() == id);
    }
}