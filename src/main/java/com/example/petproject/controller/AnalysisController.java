package com.example.petproject.controller;

import com.example.petproject.dto.AnalysisDTO;
import com.example.petproject.model.Analysis;
import com.example.petproject.model.Person;
import com.example.petproject.service.AnalysisService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/analysis")
@RestController
@RequiredArgsConstructor
@Tag(name = "анализы", description = "методы для работы с анализами")
public class AnalysisController {

    private final AnalysisService analysisService;

    @GetMapping
    @Operation(summary = "Возвращает список всех анализов")
    public List<AnalysisDTO> getAllAnalysis(){
        return analysisService.getAllAnalysis();
    }

    @GetMapping("person/{personId}")
    @Operation(summary = "Возвращает анализы пользователя по идентификатору")
    public List<AnalysisDTO> getAnalysisPerson(@PathVariable Person personId){
        return analysisService.getAllAnalysisPerson(personId);
    }

    @PostMapping("/{personId}")
    @Operation(summary = "Добавляет анализы клиента")
    public void addAnalysis(@RequestBody AnalysisDTO analysisDTO, @PathVariable Long personId){
        analysisService.saveAnalysis(analysisDTO);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "удаляет анализы пользователя по идентификатору")
    public void deleteAnalysis(@PathVariable Long id){
        analysisService.deleteAnalysis(id);
    }

}
