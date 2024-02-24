package com.example.petproject.controller;

import com.example.petproject.dto.EatingDTO;
import com.example.petproject.service.EatingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> addEating(@RequestBody EatingDTO eatingDTO){
        eatingService.addEating(eatingDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "удаляет прием птщи")
    public ResponseEntity<?> deleteEating(@PathVariable Long id){
        eatingService.deleteEating(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{personId}")
    @Operation(summary = "возвращает прием пищи по идентификатору пользователя")
    public ResponseEntity<List<EatingDTO>> getEatingPersonId(@PathVariable Long personId){
        return new ResponseEntity<>(eatingService.getEatingPerson(personId), HttpStatus.OK);
    }
}
