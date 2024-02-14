package com.example.petproject.mapper;

import com.example.petproject.dto.ExecutorDTO;
import com.example.petproject.model.Executor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ExecutorMapper {

    @Mapping(source = "executor.persons", target = "personDTOList")
    ExecutorDTO toDTO(Executor executor);

    @Mapping(target = "personDTOList", ignore = true)
    ExecutorDTO toNotPersonListDTO(Executor executor);

    Executor toExecutor(ExecutorDTO executorDTO);
}
