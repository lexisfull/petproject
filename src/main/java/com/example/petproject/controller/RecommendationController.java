package com.example.petproject.controller;

import com.example.petproject.dto.RecommendationDTO;
import com.example.petproject.model.Person;
import com.example.petproject.model.Recommendation;
import com.example.petproject.service.RecommendationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/recommendation")
@RestController
@RequiredArgsConstructor
@Tag(name = "рекоммендации", description = "методы для работы с рекоммендациями")
public class RecommendationController {

    private final RecommendationService recommendationService;

    @PostMapping
    @Operation(summary = "добавляет рекомендацию")
    public ResponseEntity<Recommendation> addRecommendation(@RequestBody RecommendationDTO recommendationDTO){
        return new ResponseEntity<>(recommendationService.addRecommendation(recommendationDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "удаляет рекомендацию по идентификатору")
    public void deleteRecommendation(@PathVariable Long id){
        recommendationService.deleteRecommendation(id);
    }

    @GetMapping("/{personId}")
    @Operation(summary = "возвращает список рекомендаций по идентификатору пользователя")
    public List<RecommendationDTO> getRecommendationPerson(@PathVariable Person personId){
        return recommendationService.getRecommendationDTOByPersonId(personId);
    }
}
