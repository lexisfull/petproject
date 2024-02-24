package com.example.petproject.service.impl;

import com.example.petproject.dao.PersonRepository;
import com.example.petproject.dao.RecommendationRepository;
import com.example.petproject.dto.RecommendationDTO;
import com.example.petproject.mapper.RecommendationMapper;
import com.example.petproject.model.Recommendation;
import com.example.petproject.service.RecommendationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RecommendationServiceImpl implements RecommendationService {

    final RecommendationRepository recommendationRepository;
    final PersonRepository personRepository;
    final RecommendationMapper recommendationMapper;

    @Override
    public Recommendation addRecommendation(RecommendationDTO recommendationDTO){
        var recommendation = recommendationMapper.toRecommendation(recommendationDTO);
        var person = personRepository.findById(recommendationDTO.getPersonId()).orElseThrow();
        recommendation.setPerson(person);
        return recommendationRepository.save(recommendation);
    }

    @Override
    public void deleteRecommendation(Long id){
        recommendationRepository.deleteById(id);
    }

    @Override
    public List<RecommendationDTO> getRecommendationDTOByPersonId(Long personId){
        return recommendationRepository.findAllByPersonId(personId)
                .stream().map(recommendationMapper::toDTO)
                .collect(Collectors.toList());
    }
}
