package com.example.petproject.controller;

import com.example.petproject.dto.PersonDTO;
import com.example.petproject.model.Person;
import com.example.petproject.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;



    @GetMapping
    @Operation(summary = "Возвращает список пользователей")
    public ResponseEntity<List<PersonDTO>> getPearson() {
        log.info("referring to the method getPearson");
        return new ResponseEntity<>(personService.getPersons(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Возвращает пользователя по идентификатору")
    public ResponseEntity<PersonDTO> getPersonById(@Parameter(description = "id пользователя")
                                                       @PathVariable("id") Long id) {
        PersonDTO person;
        try {
            person = personService.getPersonById(id);
        } catch (Exception e) {
            log.error("error get by id = {}, exception = {}", id, e.getMessage(), e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(person, HttpStatus.OK);
    }


    @GetMapping("person/{name}")
    @Operation(summary = "Возвращает пользователя по имени")
    public ResponseEntity<PersonDTO> getPersonByName(@Parameter(description = "имя пользователя")
                                                         @PathVariable String name) {
        PersonDTO personDTO;
        try {
            personDTO = personService.getPersonByName(name);
        } catch (Exception e) {
            log.error("error get by id = {}, exception = {}", name, e.getMessage(), e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(personDTO, HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Добавляет пользователя")
    public ResponseEntity<Person> addPerson(@RequestBody PersonDTO personDTO) {
        return new ResponseEntity<>(personService.createPerson(personDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удаляет пользователя")
    public ResponseEntity<?> deletePerson(@Parameter(description = "id пользователя") @PathVariable("id") Long id) {
        personService.deleteByPerson(id);
        return ResponseEntity.ok().build();
    }
}
