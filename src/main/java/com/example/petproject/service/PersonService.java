package com.example.petproject.service;

import com.example.petproject.dto.PersonDTO;
import com.example.petproject.model.Person;

import java.util.List;

public interface PersonService {

    List<PersonDTO> getPersons();

    PersonDTO getPersonById(Long id);

    PersonDTO getPersonByName(String name);

    Person createPerson(PersonDTO personDTO);

    void deleteByPerson(Long id);
}
