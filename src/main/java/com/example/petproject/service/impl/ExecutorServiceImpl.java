package com.example.petproject.service.impl;

import com.example.petproject.dao.ExecutorRepository;
import com.example.petproject.dto.ExecutorDTO;
import com.example.petproject.mapper.ExecutorMapper;
import com.example.petproject.model.Executor;
import com.example.petproject.service.ExecutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExecutorServiceImpl implements ExecutorService {

    private final ExecutorRepository executorRepository;

    private final ExecutorMapper executorMapper;

    @Override
    public List<ExecutorDTO> getAllExecutor(){
        return executorRepository.findAll().stream()
                .map(executorMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ExecutorDTO getExecutorById(Long id){
        Optional<Executor> executor = executorRepository.findById(id);
        return executorMapper.toDTO(executor.orElseThrow());
    }


    @Override
    public Executor addExecutor(ExecutorDTO executorDTO){
        return executorRepository.save(executorMapper.toExecutor(executorDTO));
    }

    @Override
    public void deleteExecutor(Long id){
        executorRepository.deleteById(id);
    }

}
