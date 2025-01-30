package com.harry.selfweb.controller;

import com.harry.selfweb.repository.UserRepository;
import com.harry.selfweb.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String email, @RequestParam String password, Model model) {
        Users users = userRepository.findByEmail(email);

        if (users == null) {
            model.addAttribute("error", "User not found!");
            return "login";
        }

        // Check password (plain text for now, use BCrypt for security)
        if (!users.getPassword().equals(password)) {
            model.addAttribute("error", "Invalid credentials!");
            return "login";
        }

        return "redirect:/products";  // Redirect to products page if login is successful
    }
}
