package com.example.petproject.dao;

import com.example.petproject.model.Measurments;
import com.example.petproject.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeasurmentsRepository extends JpaRepository<Measurments, Long> {
    List<Measurments> findAllByPersonId(Long personId);
}
