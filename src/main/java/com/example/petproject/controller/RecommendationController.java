package com.example.petproject.controller;

import com.example.petproject.dto.RecommendationDTO;
import com.example.petproject.model.Person;
import com.example.petproject.model.Recommendation;
import com.example.petproject.service.RecommendationService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/recommendation")
@RestController
@RequiredArgsConstructor
@Tag(name = "рекоммендации", description = "методы для работы с рекоммендациями")
public class RecommendationController {

    private final RecommendationService recommendationService;

    @PostMapping
    public void addRecommendation(@RequestBody RecommendationDTO recommendationDTO){
        recommendationService.addRecommendation(recommendationDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteRecommendation(@PathVariable Long id){
        recommendationService.deleteRecommendation(id);
    }

    @GetMapping("/{personId}")
    public List<RecommendationDTO> getRecommendationPerson(@PathVariable Person personId){
        return recommendationService.getRecommendationDTOByPersonId(personId);
    }
}
