package com.example.application.controller;

import com.example.application.model.*;
import com.example.application.repos.CoefDuranRepository;
import com.example.application.repos.CustomersRepository;
import com.example.application.repos.ProfessionRepository;
import com.example.application.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private CustomersRepository customerRepo;
    @Autowired
    private CoefDuranRepository coefRepo;
    @Autowired
    private ProfessionRepository profRepo;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Model model) {
        User userFromDb = userRepo.findByUsername(user.getUsername());

        if (userFromDb != null) {
            model.addAttribute("message", "User exists!");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);

        Long id = user.getId();

        Customers customer = new Customers();
        customer.setIdAccount(id);
        customerRepo.save(customer);
        id = customer.getId();
        Profession prof = new Profession();
        prof.setIdCustomer(id);
        profRepo.save(prof);
        CoefDuran coef = new CoefDuran();
        coef.setIdCustomer(id);
        coefRepo.save(coef);

        return "redirect:/login";
    }
}