package com.example.petproject.controller;

import com.example.petproject.dto.AnalysisDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/analysis")
public interface AnalysisAPI {

    @GetMapping
    @Operation(summary = "Возвращает список всех анализов")
    ResponseEntity<List<AnalysisDTO>> getAllAnalysis();

    @GetMapping("/{personId}")
    @Operation(summary = "Возвращает анализы пользователя по идентификатору")
    ResponseEntity<List<AnalysisDTO>> getAnalysisPerson(@PathVariable Long personId);

    @PostMapping
    @Operation(summary = "Добавляет анализы клиента")
    ResponseEntity<?> addAnalysis(@RequestBody AnalysisDTO analysisDTO);

    @DeleteMapping("/{id}")
    @Operation(summary = "удаляет анализы пользователя по идентификатору")
    ResponseEntity<?> deleteAnalysis(@PathVariable Long id);
}
