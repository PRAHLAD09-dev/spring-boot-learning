package com.prahlad.mvc.controller;

import com.prahlad.mvc.model.User;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController 
{

    // PATH PARAM EXAMPLE
    @GetMapping("/profile/{name}")
    public String profile(@PathVariable String name, Model model) 
    {
        model.addAttribute("name", name);
        return "profile";
    }

    // QUERY PARAM EXAMPLE
    @GetMapping("/search")
    public String search(@RequestParam String keyword, Model model) 
    {
        model.addAttribute("keyword", keyword);
        return "search";
    }

    // SHOW FORM
    @GetMapping("/register")
    public String showForm(Model model) 
    {
        model.addAttribute("user", new User());
        return "register";
    }

    // FORM SUBMIT WITH VALIDATION
    @PostMapping("/save")
    public String save(@Valid @ModelAttribute User user,
                       BindingResult result,
                       Model model) {

        if (result.hasErrors()) {
            return "register";
        }

        model.addAttribute("user", user);
        return "success";
    }
}