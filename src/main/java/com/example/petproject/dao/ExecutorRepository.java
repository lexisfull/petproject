package com.example.petproject.dao;

import com.example.petproject.model.Executor;
import com.example.petproject.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExecutorRepository extends JpaRepository<Executor, Long> {
//    List<Executor> findByPersons(List<Person> persons);
}
