package com.example.petproject.service;

import com.example.petproject.dao.RecommendationRepository;
import com.example.petproject.dto.PersonDTO;
import com.example.petproject.dto.RecommendationDTO;
import com.example.petproject.model.Person;
import com.example.petproject.model.Recommendation;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RecommendationService {

    final RecommendationRepository recommendationRepository;
    final ModelMapper modelMapper;

    public void addRecommendation(RecommendationDTO recommendationDTO){
        recommendationRepository.save(convertToRecommendation(recommendationDTO));
    }
    public void deleteRecommendation(Long id){
        recommendationRepository.deleteById(id);
    }

    public List<RecommendationDTO> getRecommendationDTOByPersonId(Person personId){
        return recommendationRepository.findAllByPersonIdOrderByDateRecommendation(personId)
                .stream().map(this::convertToRecommendationDTO)
                .collect(Collectors.toList());
    }

    private RecommendationDTO convertToRecommendationDTO(Recommendation recommendation){
        return modelMapper.map(recommendation, RecommendationDTO.class);
    }

    private Recommendation convertToRecommendation(RecommendationDTO recommendationDTO){
        return modelMapper.map(recommendationDTO, Recommendation.class);
    }
}
