package com.prahlad.mvcmicro.controller;

import com.prahlad.mvcmicro.model.User;
import com.prahlad.mvcmicro.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController 
{

    private final UserService service;

    public UserController(UserService service) 
    {
        this.service = service;
    }

    @GetMapping("/home")
    public String home() 
    {
        return "home";
    }

    @GetMapping("/register")
    public String register(Model model) 
    {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute User user, BindingResult result) 
    {
        if (result.hasErrors()) return "register";
        service.save(user);
        return "redirect:/user/list";
    }

    @GetMapping("/list")
    public String list(Model model) 
    {
        model.addAttribute("users", service.getAll());
        return "list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) 
    {
        model.addAttribute("user", service.getById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute User user) 
    {
        service.update(user);
        return "redirect:/user/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) 
    {
        service.delete(id);
        return "redirect:/user/list";
    }

    @GetMapping("/search")
    public String search(@RequestParam String keyword, Model model) 
    {
        model.addAttribute("users", service.search(keyword));
        return "list";
    }
}