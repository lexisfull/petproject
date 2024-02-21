package com.example.petproject.dao;

import com.example.petproject.model.Person;
import com.example.petproject.model.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {

    List<Recommendation> findByPerson(Person person);
}
