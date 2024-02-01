package com.example.petproject.mapper;

import com.example.petproject.dto.EatingDTO;
import com.example.petproject.model.Eating;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EatingMapper {
    EatingDTO toDTO(Eating eating);
    Eating toEating(EatingDTO eatingDTO);
}
