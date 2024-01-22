package com.example.petproject.dao;

import com.example.petproject.model.Analysis;
import com.example.petproject.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnalysisRepository extends JpaRepository<Analysis, Long> {
    List<Analysis> findByPersonId(Person personId);
}
