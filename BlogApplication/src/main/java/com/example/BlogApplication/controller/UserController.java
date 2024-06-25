package com.example.BlogApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.BlogApplication.model.User;
import com.example.BlogApplication.service.CustomUserDetailsService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public String signup(@RequestBody User user) {
        userService.save(user);
        return "User registered successfully";
    }

    // Add login method if needed
}
