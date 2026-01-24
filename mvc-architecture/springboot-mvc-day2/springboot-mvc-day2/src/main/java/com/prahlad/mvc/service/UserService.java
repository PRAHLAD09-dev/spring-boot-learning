package com.prahlad.mvc.service;

import org.springframework.stereotype.Service;
import com.prahlad.mvc.model.User;

@Service
public class UserService {

    public String registerUser(User user) {
        return "User " + user.getName() + " registered successfully!";
    }
}