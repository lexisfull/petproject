package com.example.petproject.service;

import com.example.petproject.dao.EatingRepository;
import com.example.petproject.dao.ExecutorRepository;
import com.example.petproject.dto.EatingDTO;
import com.example.petproject.dto.ExecutorDTO;
import com.example.petproject.model.Executor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExecutorService {

    private final ExecutorRepository executorRepository;

    private final ModelMapper modelMapper;

    public List<ExecutorDTO> getAllExecutor(){
        return executorRepository.findAll().stream()
                .map(this::convertExecutorDTO)
                .collect(Collectors.toList());
    }

    public ExecutorDTO getExecutorById(Long id){
        Optional<Executor> executor = executorRepository.findById(id);
        return convertExecutorDTO(executor.orElseThrow());
    }


    public void addExecutor(ExecutorDTO executorDTO){
        executorRepository.save(convertExecutor(executorDTO));
    }

    public void deleteExecutor(Long id){
        executorRepository.deleteById(id);
    }

    private ExecutorDTO convertExecutorDTO(Executor executor){
        return modelMapper.map(executor, ExecutorDTO.class);
    }

    private Executor convertExecutor(ExecutorDTO executorDTO){
        return  modelMapper.map(executorDTO, Executor.class);
    }
}
