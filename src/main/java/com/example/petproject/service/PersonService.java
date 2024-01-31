package com.example.petproject.service;


import com.example.petproject.dao.PersonRepository;
import com.example.petproject.dto.PersonDTO;
import com.example.petproject.mapper.PersonMapper;
import com.example.petproject.model.Person;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    private final PersonMapper personMapper;

    public List<PersonDTO> getPersons() {
        return personRepository.findAll().stream()
                .map(personMapper::toDTONotAnalysis)
                .collect(Collectors.toList());
    }

    public PersonDTO getPersonById(Long id) {
        log.info("запрошен пользователь с id: {}", id);
        Optional<Person> person = personRepository.findById(id);
        return personMapper.toDTO(person.orElseThrow());
    }

    public PersonDTO getPersonByName(String name) {
        log.info("запрошен пользователь с name: {}", name);
        Optional<Person> person = Optional.ofNullable(personRepository.findByName(name));
        return personMapper.toDTO(person.orElseThrow());
    }

    public void savePerson(PersonDTO personDTO) {

        var person = personMapper.toPerson(personDTO);
        personRepository.save(person);
    }

    public void deleteByPerson(Long id) {
        personRepository.deleteById(id);
    }

}
