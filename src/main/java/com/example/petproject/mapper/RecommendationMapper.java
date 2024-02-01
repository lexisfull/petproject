package com.example.petproject.mapper;

import com.example.petproject.dto.RecommendationDTO;
import com.example.petproject.model.Recommendation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RecommendationMapper {

    RecommendationDTO toDTO(Recommendation recommendation);

    Recommendation toRecommendation(RecommendationDTO recommendationDTO);
}
