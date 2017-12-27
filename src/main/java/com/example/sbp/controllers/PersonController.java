package com.example.sbp.controllers;

import com.example.sbp.commands.PersonForm;
import com.example.sbp.converters.PersonToPersonForm;
import com.example.sbp.domain.Person;
import com.example.sbp.services.JournalService;
import com.example.sbp.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Controller
public class PersonController {
    private PersonService personService;
    private PersonToPersonForm personToPersonForm;
    private JournalService journalService;

    @Autowired
    public void setPersonToPersonForm(PersonToPersonForm personToPersonForm) {
        this.personToPersonForm = personToPersonForm;
    }
    @Autowired
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    @Autowired
    public PersonController(JournalService journalService) {
        this.journalService = journalService;
    }




    @RequestMapping("/person/person_stats")
    public String redictToStatistic(Model model){
        model.addAttribute("journals", journalService.listAll());
        return "person/person_stats";
    }



    @RequestMapping("/")
    public String redirectToList(){
        return "redirect:/person/list";
    }

    @RequestMapping({"/person/list", "/person"})
    public String listUsers(Model model){
        model.addAttribute("persons", personService.listAll());
        return "person/list";
    }

    @RequestMapping("/person/show/{id}")
    public String getUser(@PathVariable String id, Model model){
        model.addAttribute("person", personService.getById(Long.valueOf(id)));
        return "person/show";
    }


    @RequestMapping("person/edit/{id}")
    public String edit(@PathVariable String id, Model model){
        Person person =  personService.getById(Long.valueOf(id));
        PersonForm personForm = personToPersonForm.convert(person);
        model.addAttribute("personForm", personForm);
        return "person/personform";
    }


    @RequestMapping("/person/new")
    public String newUser(Model model){
        model.addAttribute("personForm",new PersonForm());
        return "person/personform";
    }

    @RequestMapping(value = "/person", method = RequestMethod.POST)
    public String saveOrUpdateUser(@Valid PersonForm personForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "person/personform";
        }

        Person savedPerson = personService.saveOrUpdateProductForm(personForm);
        return "redirect:/person/show/"+ savedPerson.getId();
    }


    @RequestMapping("/person/delete/{id}")
    public String delete(@PathVariable String id){
        personService.delete(Long.valueOf(id));
        return "redirect:/person/list";
    }


}
