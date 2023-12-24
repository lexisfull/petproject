package com.example.petproject.dao;

import com.example.petproject.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    List<Person> findAllByAge(int age);
}
