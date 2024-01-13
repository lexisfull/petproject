package com.example.petproject.controller;

import com.example.petproject.model.Person;
import com.example.petproject.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

/**
 * Рестконтроллер на который будет обращаться клиент
 */
@Slf4j
@RequestMapping("/persons")
@RestController
@Tag(name = "Пользователи", description = "Методы для работы с пользователями")
public class PersonController {
    @Autowired
    private PersonService personService;


    @GetMapping
    @Operation(summary = "Возвращает список пользователей")
    public List<Person> getPearson() {
        log.info("referring to the method getPearson");
        return personService.getPersons();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Возвращает пользователя по идентификатору")
    public Person getPersonById(@Parameter(description = "id пользователя") @PathVariable Integer id) {
        return personService.getPersonById(id);
    }

    @PostMapping
    @Operation(summary = "Добавляет пользователя")
    public void addPerson(@RequestBody Person person) {
        personService.savePerson(person);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удаляет пользователя")
    public void deletePerson(@Parameter(description = "id пользователя") @PathVariable("id") Integer id) {
        personService.deleteByPerson(id);
    }

}
