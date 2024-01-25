package com.example.petproject.controller;

import com.example.petproject.dto.EatingDTO;
import com.example.petproject.model.Person;
import com.example.petproject.service.EatingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/eating")
@RestController
@RequiredArgsConstructor
@Tag(name = "Приемы пищи", description = "методы для приема пищи")
public class EatingController {

    private final EatingService eatingService;

    @PostMapping
    @Operation(summary = "Добавляет прием пищи")
    public void addEating(@RequestBody EatingDTO eatingDTO){
        eatingService.addEating(eatingDTO);
    }

    @DeleteMapping
    @Operation(summary = "удаляет прием птщи")
    public void deleteEating(Long id){
        eatingService.deleteEating(id);
    }

    @GetMapping("eat/{personId}")
    @Operation(summary = "возвращает прием пищи по идентификатору пользователя")
    public List<EatingDTO> getEatingPersonId(@PathVariable Person personId){
        return eatingService.getEatingPerson(personId);
    }
}
