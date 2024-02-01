package com.example.petproject.mapper;

import com.example.petproject.dto.ExecutorDTO;
import com.example.petproject.model.Executor;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ExecutorMapper.class})
public interface ExecutorListMapper {
    List<ExecutorDTO> toDTO(List<Executor> executorList);
    List<Executor> toExecutor(List<ExecutorDTO> executorDTOList);
}
