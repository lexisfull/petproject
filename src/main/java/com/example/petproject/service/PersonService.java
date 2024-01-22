package com.example.petproject.service;

import com.example.petproject.dao.PersonRepository;
import com.example.petproject.dto.PersonDTO;
import com.example.petproject.model.Person;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;
    private final ModelMapper modelMapper;

    public List<PersonDTO> getPersons() {
        return personRepository.findAll().stream()
                .map(this::convertPersonDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO getPersonById(Long id) {
        log.info("запрошен пользователь с id: {}", id);
        Optional<Person> person = personRepository.findById(id);
        return convertPersonDTO(person.orElseThrow());
    }

    public PersonDTO getPersonByName(String name) {
        log.info("запрошен пользователь с name: {}", name);
        Optional<Person> person = Optional.ofNullable(personRepository.findByName(name));
        return convertPersonDTO(person.orElseThrow());
    }

    public void savePerson(PersonDTO personDTO) {
        personRepository.save(convertPerson(personDTO));
    }

    public List<Person> getListPersonByAge(Integer age) {
        Optional<List<Person>> personList = Optional.ofNullable(personRepository.findAllByAge(age));
        return personList.orElseThrow();
    }


    public void deleteByPerson(Long id) {
        personRepository.deleteById(id);
    }

    private PersonDTO convertPersonDTO(Person person){
        return modelMapper.map(person, PersonDTO.class);
    }

    private Person convertPerson(PersonDTO personDTO){
        return modelMapper.map(personDTO, Person.class);
    }
}
