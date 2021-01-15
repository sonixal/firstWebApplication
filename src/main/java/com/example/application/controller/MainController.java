package com.example.application.controller;

import com.example.application.model.User;
import com.example.application.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {
@Autowired
private UserRepository userRepos;


    @GetMapping("/")
    public String greeting(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userRepos.findByUsername(name);

        model.addAttribute("user", user);
        return "greeting";
    }

}
