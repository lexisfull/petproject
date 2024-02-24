package com.example.petproject.controller.api;

import com.example.petproject.controller.RecommendationController;
import com.example.petproject.dto.RecommendationDTO;
import com.example.petproject.model.Recommendation;
import com.example.petproject.service.RecommendationService;
import io.swagger.v3.oas.annotations.Operation;
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
public class RecommendationAPI implements RecommendationController {

    private final RecommendationService recommendationService;

    @Override
    public ResponseEntity<Recommendation> addRecommendation(@RequestBody RecommendationDTO recommendationDTO){
        return new ResponseEntity<>(recommendationService.addRecommendation(recommendationDTO), HttpStatus.CREATED);
    }

    @Override
    public HttpStatus deleteRecommendation(@PathVariable Long id){
        recommendationService.deleteRecommendation(id);
        return HttpStatus.OK;
    }

    @Override
    public List<RecommendationDTO> getRecommendationPerson(@PathVariable Long personId){
        return recommendationService.getRecommendationDTOByPersonId(personId);
    }
}
