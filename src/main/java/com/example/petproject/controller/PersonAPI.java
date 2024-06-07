package com.example.petproject.controller;

import com.example.petproject.dto.PersonDTO;
import com.example.petproject.model.Person;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/persons")
public interface PersonAPI {

    @GetMapping
    @Operation(summary = "Возвращает список пользователей")
    ResponseEntity<List<PersonDTO>> getPearson();

    @GetMapping("/{id}")
    @Operation(summary = "Возвращает пользователя по идентификатору")
    ResponseEntity<PersonDTO> getPersonById(@Parameter(description = "id пользователя") @PathVariable("id") Long id);

    @GetMapping("person/{name}")
    @Operation(summary = "Возвращает пользователя по имени")
    ResponseEntity<PersonDTO> getPersonByName(@Parameter(description = "имя пользователя")
                                                     @PathVariable String name);

    @PostMapping
    @Operation(summary = "Добавляет пользователя")
    ResponseEntity<Person> addPerson(@RequestBody PersonDTO personDTO);

    @DeleteMapping("/{id}")
    @Operation(summary = "Удаляет пользователя")
    ResponseEntity<?> deletePerson(@Parameter(description = "id пользователя") @PathVariable("id") Long id);
}
