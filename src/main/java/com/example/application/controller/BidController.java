package com.example.application.controller;

import com.example.application.model.*;
import com.example.application.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class BidController {

    @Autowired
    private DocumentRepository docrepo;
    @Autowired
    private UserRepository userRepos;
    @Autowired
    private WorkersRepository workersRepos;
    @Autowired
    private ProfessionRepository profRepos;
    @Autowired
    private CoefDuranRepository coefRepos;
    @Autowired
    private CustomersRepository customersRepos;


    @GetMapping("/add")
    public String bid(Model model){

        return "addBid";
    }

    @PostMapping("/add")
    public String addBid(
            @RequestParam int sum,
            @RequestParam int percent,
            @RequestParam int duration,
            Model model){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userRepos.findByUsername(name);
        Long id = user.getId();
        Customers customers = customersRepos.findByIdAccount(id);
        id = customers.getId();
        String checked = "NOT CHECKED";
        Document document = new Document (sum, percent, duration, checked);
        document.setIdCustomer(id);
        document.setStatus("WAITED");
        docrepo.save(document);

        return "main";
    }

    @GetMapping("/{id}-bid")
    public String showBid(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userRepos.findByUsername(name);
        Long id = user.getId();
        Customers customers = customersRepos.findByIdAccount(id);
        id = customers.getId();
        List<Document> documents = docrepo.findByIdCustomer(id);

        model.addAttribute("documents", documents);

        return "showBid";

    }

    @GetMapping("/bid-a")
    public String showBidAdmin(@RequestParam(required = false, value = "id", defaultValue = "0") Long id, Model model){
        List<Document> documents = docrepo.findAll();
        if(id!= 0) {
            docrepo.deleteById(id);
            return "redirect:/bid-a";
        }
        model.addAttribute("documents", documents);
        return "allBid";
    }

    @PostMapping("/bid-a")
    public String deleteBid(@RequestParam(value = "id") Long id, Model model){
            docrepo.deleteById(id);

        return "redirect:/bid-a";
    }

    @GetMapping("/bid")
    public String showAllBid(Model model){
        List<Document> documents = docrepo.findAll();
            for(int i = 0; i<documents.size();i++) {
                Long id = documents.get(i).getId();
                Document document = docrepo.findObjectById(id);
                Long buf = document.getIdCustomer();
                Profession prof = profRepos.findByIdCustomer(buf);
                CoefDuran duran = coefRepos.findByIdCustomer(buf);
                float coef = 0;
                if (duran.getSex().equals("female")) {
                    coef += 0.4;
                }
                if (duran.getAge() > 20 && duran.getAge() < 50) {
                    int age = 50 - duran.getAge();
                    coef += 0.01 * age;
                } else if (duran.getAge() > 50) {
                    coef += 0.3;
                }
                if (duran.isBankAccount()) {
                    coef += 0.42;
                }
                if (duran.isProperty()) {
                    coef += 0.35;
                }
                if (prof.getProfessionDistrict().equals("Community")) {
                    coef += 0.21;
                }
                if (prof.getProfessionRisk().equals("Low")) {
                    coef += 0.55;
                } else if (prof.getProfessionRisk().equals("High")) {
                    coef += 0;
                } else {
                    coef += 0.16;
                }
                coef += prof.getExperience() * 0.06;

                document.setCoef(coef);
                docrepo.save(document);
            }

        model.addAttribute("documents", documents);

        return "allBid";
    }

    @PostMapping("/bid")
    public String changeStatus(@RequestParam(required=false) String decision, Model model){
        String[] buf = new String[1];
        buf = decision.split(" ");
        Long id = Long.parseLong(buf[0]);
        Document document = docrepo.findObjectById(id);
        document.setStatus(buf[1]);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userRepos.findByUsername(name);
        id = user.getId();
        Workers workers = workersRepos.findByIdAccount(id);
        id = workers.getId();
        document.setIdWorker(id);

        docrepo.save(document);

        return "redirect:/bid";
    }
}
