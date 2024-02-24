package com.example.petproject.service;

import com.example.petproject.dto.ExecutorDTO;
import com.example.petproject.model.Executor;

import java.util.List;

public interface ExecutorService {

    List<ExecutorDTO> getAllExecutor();

    ExecutorDTO getExecutorById(Long id);

    Executor addExecutor(ExecutorDTO executorDTO);

    void deleteExecutor(Long id);
}
