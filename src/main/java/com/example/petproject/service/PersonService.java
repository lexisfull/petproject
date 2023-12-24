package com.example.petproject.service;

import com.example.petproject.dao.PersonRepository;
import com.example.petproject.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;
    public List<Person> getPersons(){
        return personRepository.findAll();
    }

    public Person getPersonById(Integer id){
        Optional<Person> person = personRepository.findById(id);
        return person.orElseThrow();
    }

    public void savePerson(Person person) {
        personRepository.save(person);
    }

    public List<Person> getListPersonByAge(int age){
        return personRepository.findAllByAge(age);
    }
}
