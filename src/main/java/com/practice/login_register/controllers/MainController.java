package com.practice.login_register.controllers;

import com.practice.login_register.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String r_loginPage() {
        return "login_register";
    }

    @GetMapping("/dashboard")
    public String r_dashboard() {
        return null;
    }

    @PostMapping("/register")
    public String p_registerUser() {
        return null;
    }

    @PostMapping("/login")
    public String p_login() {
        return null;
    }

//    Log out by clearing session and sending back to login/register page
    @GetMapping("/logout")
    public String p_logout() {
        return null;
    }

}
