package com.example.petproject.dao;

import com.example.petproject.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findAllByAge(int age);
    Person findByName(String name);
}
