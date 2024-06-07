package com.example.petproject.controller;

import com.example.petproject.dto.EatingDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/eating")
public interface EatingApi {

    @PostMapping
    @Operation(summary = "Добавляет прием пищи")
    ResponseEntity<?> addEating(@RequestBody EatingDTO eatingDTO);

    @DeleteMapping("/{id}")
    @Operation(summary = "удаляет прием птщи")
    ResponseEntity<?> deleteEating(@PathVariable Long id);

    @GetMapping("/{personId}")
    @Operation(summary = "возвращает прием пищи по идентификатору пользователя")
    ResponseEntity<List<EatingDTO>> getEatingPersonId(@PathVariable Long personId);
}
