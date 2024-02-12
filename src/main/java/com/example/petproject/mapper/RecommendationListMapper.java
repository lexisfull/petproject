package com.example.petproject.mapper;

import com.example.petproject.dto.RecommendationDTO;
import com.example.petproject.model.Recommendation;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = RecommendationMapper.class)
public interface RecommendationListMapper {
    List<RecommendationDTO> toDTO(List<Recommendation> recommendationList);
    List<Recommendation> toRecommendationList(List<RecommendationDTO> recommendationDTOList);
}
