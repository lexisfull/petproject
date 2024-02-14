package com.example.petproject.controller;

import com.example.petproject.dto.EatingDTO;
import com.example.petproject.model.Person;
import com.example.petproject.service.EatingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/eating")
@RestController
@RequiredArgsConstructor
@Tag(name = "Приемы пищи", description = "методы для приема пищи")
public class EatingController {

    private final EatingService eatingService;

    @PostMapping("/{personId}")
    @Operation(summary = "Добавляет прием пищи")
    public HttpStatus addEating(@RequestBody EatingDTO eatingDTO, @PathVariable Person personId){
        eatingService.addEating(eatingDTO, personId);
        return HttpStatus.OK;
    }

    @DeleteMapping
    @Operation(summary = "удаляет прием птщи")
    public void deleteEating(Long id){
        eatingService.deleteEating(id);
    }

    @GetMapping("/{personId}")
    @Operation(summary = "возвращает прием пищи по идентификатору пользователя")
    public List<EatingDTO> getEatingPersonId(@PathVariable Person personId){
        return eatingService.getEatingPerson(personId);
    }
}
