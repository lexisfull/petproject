package com.example.petproject.dao;

import com.example.petproject.model.Executor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExecutorRepository extends JpaRepository<Executor, Integer> {
}
