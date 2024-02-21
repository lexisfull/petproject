package com.example.petproject.mapper;

import com.example.petproject.dto.EatingDTO;
import com.example.petproject.model.Eating;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EatingMapper {

    @Mapping(source = "products", target = "productsDTOlist")
    @Mapping(source = "person.id", target = "person")
    EatingDTO toDTO(Eating eating);

    @Mapping(target = "person", ignore = true)
    Eating toEating(EatingDTO eatingDTO);
}
