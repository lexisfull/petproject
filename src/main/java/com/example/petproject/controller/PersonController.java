package com.example.petproject.controller;

import com.example.petproject.model.Person;
import com.example.petproject.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Рестконтроллер на который будет обращаться клиент
 */
@RequestMapping("/persons")
@RestController
@Tag(name = "Пользователи", description = "Методы для работы с пользователями")
public class PersonController {
    @Autowired
    private PersonService personService;


    @GetMapping
    @Operation(summary = "Возвращает список пользователей")
    public List<Person> getPearson(){
        return personService.getPersons();
    }
    @GetMapping("/{id}")
    @Operation(summary = "Возвращает пользователя по идентификатору")
    public Person getPersonById(@PathVariable Integer id){
        return personService.getPersonById(id);
    }


    @PostMapping
    @Operation(summary = "Добавляет пользователя")
    public void addPerson(@RequestBody Person person){
        personService.savePerson(person);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удаляет пользователя")
    public void deletePerson(@PathVariable("id") Integer id){
        personService.deleteByPerson(id);
    }

}
