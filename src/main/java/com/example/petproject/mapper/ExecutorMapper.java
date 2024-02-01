package com.example.petproject.mapper;

import com.example.petproject.dto.ExecutorDTO;
import com.example.petproject.model.Executor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExecutorMapper {

    ExecutorDTO toDTO(Executor executor);

    Executor toExecutor(ExecutorDTO executorDTO);
}
