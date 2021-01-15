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
public class CreditsController {
    @Autowired
    private UserRepository userRepos;
    @Autowired
    private DocumentRepository docsRepos;
    @Autowired
    private CreditsRepository creditsRepos;
    @Autowired
    private CustomersRepository customerRepos;
    @Autowired
    private WorkersRepository workersRepos;

    @GetMapping("/{user}-credits")
    public String showCredits(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userRepos.findByUsername(name);
        Long id = user.getId();
        Customers customers = customerRepos.findByIdAccount(id);
        id = customers.getId();
        List<Credits> credits = creditsRepos.findByIdCustomers(id);
        List<Document> documents = docsRepos.findByIdCustomer(id);

        model.addAttribute("credits",credits);
        model.addAttribute("documents",documents);

        return "showCredits";
    }

    @GetMapping("/show-credits")
    public String showAllCredits(@RequestParam(required = false, value = "id", defaultValue = "0") Long id,
                                 @RequestParam(required = false) Long filter,
                                 Model model) {
        Iterable<Credits> credits = creditsRepos.findAll();
        if(id!= 0) {
            creditsRepos.deleteById(id);
            return "redirect:/show-credits";
        }
        if(filter!=null) {
            credits = creditsRepos.findByIdDocument(filter);
        } else {
            credits = creditsRepos.findAll();
        }
        model.addAttribute("credits", credits);
        model.addAttribute("filters", filter);
        return "showCredits";
    }

    @GetMapping("/credits")
    public String showApprovedCredits(Model model) {
        Iterable<Document> documents = docsRepos.findAll();

        model.addAttribute("documents", documents);
        return "approveCredits";
    }


    @PostMapping("/credits")
    public String approveCredits(@RequestParam(required=false) String decision, Model model){
        String[] buf = new String[1];
        buf = decision.split(" ");
        Long idDoc = Long.parseLong(buf[0]);
        String state = buf[1];
            Document document = docsRepos.findObjectById(idDoc);
            Long id = document.getIdCustomer();
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String name = auth.getName();
            User user = userRepos.findByUsername(name);
            Long idWorker = user.getId();
            Credits credits = new Credits(idDoc, id, state, idWorker);
            document.setChecked(state);

            docsRepos.save(document);
            creditsRepos.save(credits);


        return "redirect:/credits";
    }

}
