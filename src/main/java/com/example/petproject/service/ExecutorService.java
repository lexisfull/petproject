package com.example.petproject.service;

import com.example.petproject.dao.EatingRepository;
import com.example.petproject.dao.ExecutorRepository;
import com.example.petproject.dto.EatingDTO;
import com.example.petproject.dto.ExecutorDTO;
import com.example.petproject.mapper.ExecutorMapper;
import com.example.petproject.model.Executor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExecutorService {

    private final ExecutorRepository executorRepository;
    private final ExecutorMapper executorMapper;

    public List<ExecutorDTO> getAllExecutor(){
        return executorRepository.findAll().stream()
                .map(executorMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ExecutorDTO getExecutorById(Long id){
        Optional<Executor> executor = executorRepository.findById(id);
        return executorMapper.toDTO(executor.orElseThrow());
    }


    public Executor addExecutor(ExecutorDTO executorDTO){
        return executorRepository.save(executorMapper.toExecutor(executorDTO));
    }

    public void deleteExecutor(Long id){
        executorRepository.deleteById(id);
    }

}
