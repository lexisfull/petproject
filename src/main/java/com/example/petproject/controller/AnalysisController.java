package com.example.petproject.controller;

import com.example.petproject.dto.AnalysisDTO;
import com.example.petproject.service.AnalysisService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RequestMapping("/analysis")
@RestController
@RequiredArgsConstructor
@Tag(name = "анализы", description = "методы для работы с анализами")
public class AnalysisController {

    private final AnalysisService analysisService;

    @GetMapping
    @Operation(summary = "Возвращает список всех анализов")
    public ResponseEntity<List<AnalysisDTO>> getAllAnalysis(){
        return new ResponseEntity<>(analysisService.getAllAnalysis(), HttpStatus.OK);
    }

    @GetMapping("/{personId}")
    @Operation(summary = "Возвращает анализы пользователя по идентификатору")
    public ResponseEntity<List<AnalysisDTO>> getAnalysisPerson(@PathVariable Long personId){
        return new ResponseEntity<>(analysisService.getAllAnalysisPerson(personId), HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Добавляет анализы клиента")
    public ResponseEntity<?> addAnalysis(@RequestBody AnalysisDTO analysisDTO){
        analysisService.saveAnalysis(analysisDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "удаляет анализы пользователя по идентификатору")
    public ResponseEntity<?> deleteAnalysis(@PathVariable Long id){
        analysisService.deleteAnalysis(id);
        return ResponseEntity.ok().build();
    }

}
