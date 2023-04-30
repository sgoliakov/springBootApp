package org.example.springBootApp.logic.controllers;

import org.example.springBootApp.logic.DAO.PeopleJdbcTemplateDAO;
import org.example.springBootApp.logic.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final PeopleJdbcTemplateDAO peopleJdbcTemplateDAO;

    @Autowired
    public AdminController(PeopleJdbcTemplateDAO peopleJdbcTemplateDAO) {
        this.peopleJdbcTemplateDAO = peopleJdbcTemplateDAO;
    }

    @GetMapping()
    public String admin_page(Model model, @ModelAttribute("person") Person person) {
        model.addAttribute("people", peopleJdbcTemplateDAO.getPeople());
        return "/admin/admin_page";
    }
    @PatchMapping("/add")
    public String newAdmin(@ModelAttribute("person") Person person){
      //  peopleJdbcTemplateDAO.addAdmin();
        System.out.println(person.getId());
        return "redirect:/people";
    }

}