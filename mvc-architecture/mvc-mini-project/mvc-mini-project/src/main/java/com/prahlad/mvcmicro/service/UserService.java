package com.prahlad.mvcmicro.service;

import com.prahlad.mvcmicro.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private List<User> users = new ArrayList<>();
    private int counter = 1;

    public void save(User user) 
    {
        user.setId(counter++);
        users.add(user);
    }

    public List<User> getAll() 
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

    public void update(User updated) 
    {
        for (User u : users) {
            if (u.getId() == updated.getId()) 
            {
                u.setName(updated.getName());
                u.setEmail(updated.getEmail());
            }
        }
    }

    public void delete(int id) 
    {
        users.removeIf(u -> u.getId() == id);
    }

    public List<User> search(String keyword) 
    {
        return users.stream()
                .filter(u -> u.getName().toLowerCase().contains(keyword.toLowerCase())
                          || u.getEmail().toLowerCase().contains(keyword.toLowerCase()))
                .toList();
    }
}