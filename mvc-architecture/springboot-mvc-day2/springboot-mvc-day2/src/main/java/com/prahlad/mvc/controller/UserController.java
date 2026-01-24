package com.prahlad.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.prahlad.mvc.model.User;
import com.prahlad.mvc.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController 
{

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showForm() 
    {
        return "register";
    }

    @PostMapping("/save")
    public String saveUser(@RequestParam String name,
                           @RequestParam String email,
                           Model model) 
    {

        User user = new User(name, email);
        String msg = userService.registerUser(user);

        model.addAttribute("message", msg);
        model.addAttribute("user", user);

        return "success";
    }
}