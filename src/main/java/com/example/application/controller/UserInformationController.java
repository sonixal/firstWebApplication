package com.example.application.controller;

import com.example.application.model.*;
import com.example.application.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserInformationController {
    @Autowired
    private CoefDuranRepository coefDuranRepos;
    @Autowired
    private ProfessionRepository professionRepos;
    @Autowired
    private CustomersRepository customersRepos;
    @Autowired
    private UserRepository userRepos;
    @Autowired
    private WorkersRepository workersRepos;


    @GetMapping("/{id}-{user}")

    public String showInfo(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userRepos.findByUsername(name);
            Long id = user.getId();
            Customers customers = customersRepos.findByIdAccount(id);
            id = customers.getId();
            Profession profession = professionRepos.findByIdCustomer(id);
            CoefDuran coefDuran = coefDuranRepos.findByIdCustomer(id);

                model.addAttribute("customers", customers);
                model.addAttribute("profession", profession);
                model.addAttribute("coef", coefDuran);

                id = user.getId();
                Workers workers = workersRepos.findByIdAccount(id);
                model.addAttribute("user", user);
                model.addAttribute("workers", workers);

        return "showInfo";

    }

    @GetMapping("/{id}-{user}-a")
    public String showInfoAdmin(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userRepos.findByUsername(name);
        Long id = user.getId();
        Workers workers = workersRepos.findByIdAccount(id);
        model.addAttribute("workers", workers);

        return "showInfo";

    }

    @GetMapping("/{id}-{user}-edit")
    public String infoEdit(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String accName = auth.getName();
        User user = userRepos.findByUsername(accName);
        Long id = user.getId();
        Customers customers = customersRepos.findByIdAccount(id);
        id = customers.getId();
        Profession profession = professionRepos.findByIdCustomer(id);
        CoefDuran duran = coefDuranRepos.findByIdCustomer(id);

        model.addAttribute("user", user);
        model.addAttribute("customers", customers);
        model.addAttribute("profession", profession);
        model.addAttribute("coef", duran);

        return "infoEdit";
    }

    @PostMapping("/{id}-{user}-edit")
    public String infoUserEdit(
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam String inn,
            @RequestParam int age,
            @RequestParam String sex,
            @RequestParam boolean bankAccount,
            @RequestParam boolean property,
            @RequestParam String professionName,
            @RequestParam String professionDistrict,
            @RequestParam String professionRisk,
            @RequestParam int experience,
            Model model
    )
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String accName = auth.getName();
        User user = userRepos.findByUsername(accName);
        Long id = user.getId();
        Customers customers = customersRepos.findByIdAccount(id);
        id = customers.getId();
        Profession profession = professionRepos.findByIdCustomer(id);
        CoefDuran duran = coefDuranRepos.findByIdCustomer(id);

        customers.setName(name);
        customers.setSurname(surname);
        customers.setInn(inn);
        customersRepos.save(customers);

        duran.setAge(age);
        duran.setSex(sex);
        duran.setBankAccount(bankAccount);
        duran.setProperty(property);
        coefDuranRepos.save(duran);

        profession.setNameProfession(professionName);
        profession.setProfessionDistrict(professionDistrict);
        profession.setProfessionRisk(professionRisk);
        profession.setExperience(experience);
        professionRepos.save(profession);

        return "redirect:/{id}-{user}";
    }

}
