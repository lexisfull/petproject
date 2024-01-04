package com.example.petproject.controller;

import com.example.petproject.model.Person;
import com.example.petproject.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Рестконтроллер на который будет обращаться клиент
 */
@RequestMapping("/persons")
@RestController
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping
    public List<Person> getPearson(){
        return personService.getPersons();
    }
    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable Integer id){
        return personService.getPersonById(id);
    }

//    @GetMapping
//    public Person getPersonById2(@RequestParam Integer id){
//        return personService.getPersonById(id);
//    }

    @PostMapping
    public void addPerson(@RequestBody Person person){
        personService.savePerson(person);
    }
    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable("id") Integer id){
        personService.deleteByPerson(id);
    }

}
