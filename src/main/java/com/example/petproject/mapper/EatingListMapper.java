package com.example.petproject.mapper;

import com.example.petproject.dto.EatingDTO;
import com.example.petproject.model.Eating;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {EatingMapper.class})
public interface EatingListMapper {

    List<EatingDTO> toEatingDTOList(List<Eating> eatingList);

    List<Eating> toEatingList(List<EatingDTO> eatingDTOList);
}
