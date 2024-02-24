package com.example.petproject.controller;

import com.example.petproject.dto.RecommendationDTO;
import com.example.petproject.model.Recommendation;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/recommendation")
public interface RecommendationController {

    @PostMapping
    @Operation(summary = "добавляет рекомендацию")
    public ResponseEntity<Recommendation> addRecommendation(@RequestBody RecommendationDTO recommendationDTO);

    @DeleteMapping("/{id}")
    @Operation(summary = "удаляет рекомендацию по идентификатору")
    public HttpStatus deleteRecommendation(@PathVariable Long id);

    @GetMapping("/{personId}")
    @Operation(summary = "возвращает список рекомендаций по идентификатору пользователя")
    public List<RecommendationDTO> getRecommendationPerson(@PathVariable Long personId);
}
