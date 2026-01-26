package com.prahlad.mvc.controller;

import com.prahlad.mvc.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private List<User> users = new ArrayList<>();
    private int counter = 1;

    // SHOW REGISTER PAGE
    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    // SAVE USER
    @PostMapping("/save")
    public String save(@ModelAttribute User user) {
        user.setId(counter++);
        users.add(user);
        return "redirect:/user/list";
    }

    // LIST USERS
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("users", users);
        return "list";
    }

    // EDIT USER PAGE
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        for (User u : users) {
            if (u.getId() == id) {
                model.addAttribute("user", u);
                return "edit";
            }
        }
        return "redirect:/user/list";
    }

    // UPDATE USER
    @PostMapping("/update")
    public String update(@ModelAttribute User updatedUser) {
        for (User u : users) {
            if (u.getId() == updatedUser.getId()) {
                u.setName(updatedUser.getName());
                u.setEmail(updatedUser.getEmail());
            }
        }
        return "redirect:/user/list";
    }

    // DELETE USER
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        users.removeIf(user -> user.getId() == id);
        return "redirect:/user/list";
    }
}