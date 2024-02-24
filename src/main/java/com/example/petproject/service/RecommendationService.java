package com.example.petproject.service;

import com.example.petproject.dto.RecommendationDTO;
import com.example.petproject.model.Recommendation;

import java.util.List;

public interface RecommendationService {

    Recommendation addRecommendation(RecommendationDTO recommendationDTO);

    void deleteRecommendation(Long id);

    List<RecommendationDTO> getRecommendationDTOByPersonId(Long personId);
}
