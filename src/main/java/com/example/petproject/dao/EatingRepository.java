package com.example.petproject.dao;

import com.example.petproject.model.Eating;
import com.example.petproject.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EatingRepository extends JpaRepository<Eating, Long> {

    List<Eating> findAllByPersonIdOrderByDateTime(Long personId);
}
