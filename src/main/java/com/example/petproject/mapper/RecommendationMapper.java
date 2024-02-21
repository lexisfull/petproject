package com.example.petproject.mapper;

import com.example.petproject.dto.RecommendationDTO;
import com.example.petproject.model.Recommendation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RecommendationMapper {

    @Mapping(source = "person.id", target = "person")
    RecommendationDTO toDTO(Recommendation recommendation);

    @Mapping(target = "person", ignore = true)
    Recommendation toRecommendation(RecommendationDTO recommendationDTO);
}
