package com.example.petproject.controller.api;

import com.example.petproject.dto.PersonDTO;
import com.example.petproject.model.Person;
import com.example.petproject.service.PersonService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * Рестконтроллер на который будет обращаться клиент
 */
@Slf4j
@RequestMapping("/users")
@RestController
@Tag(name = "Пользователи", description = "Методы для работы с пользователями")
@RequiredArgsConstructor
public class PersonController implements com.example.petproject.controller.PersonAPI {

    private final PersonService personService;



   @Override
    public ResponseEntity<List<PersonDTO>> getPearson() {
        log.info("referring to the method getPearson");
        return new ResponseEntity<>(personService.getPersons(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PersonDTO> getPersonById(@Parameter(description = "id пользователя")
                                                       @RequestHeader Long id) {
        PersonDTO person;
        try {
            person = personService.getPersonById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
        return new ResponseEntity<>(person, HttpStatus.OK);
    }


    @Override
    public ResponseEntity<PersonDTO> getPersonByName(@Parameter(description = "имя пользователя")
                                                         @RequestHeader String name) {
        PersonDTO personDTO;
        try {
            personDTO = personService.getPersonByName(name);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
        return new ResponseEntity<>(personDTO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Person> addPerson(@RequestBody PersonDTO personDTO) {
        return new ResponseEntity<>(personService.createPerson(personDTO), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> deletePerson(@Parameter(description = "id пользователя") @PathVariable("id") Long id) {
        personService.deleteByPerson(id);
        return ResponseEntity.ok().build();
    }
}
