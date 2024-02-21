package com.example.petproject.service;

import com.example.petproject.dao.PersonRepository;
import com.example.petproject.dao.RecommendationRepository;
import com.example.petproject.dto.RecommendationDTO;
import com.example.petproject.mapper.RecommendationMapper;
import com.example.petproject.model.Person;
import com.example.petproject.model.Recommendation;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RecommendationService {

    final RecommendationRepository recommendationRepository;
    final PersonRepository personRepository;
    final RecommendationMapper recommendationMapper;
    public void addRecommendation(RecommendationDTO recommendationDTO){
        var recommendation = recommendationMapper.toRecommendation(recommendationDTO);
        var person = personRepository.findById(recommendationDTO.getPerson()).orElseThrow();
        recommendation.setPerson(person);
        recommendationRepository.save(recommendation);
    }
    public void deleteRecommendation(Long id){
        recommendationRepository.deleteById(id);
    }

    public List<RecommendationDTO> getRecommendationDTOByPersonId(Person person){
        return recommendationRepository.findByPerson(person)
                .stream().map(recommendationMapper::toDTO)
                .collect(Collectors.toList());
    }
}
