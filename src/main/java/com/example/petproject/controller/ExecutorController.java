package com.example.petproject.controller;

import com.example.petproject.dto.ExecutorDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/executor")
public interface ExecutorController {

    @PostMapping
    @Operation(summary = "добавляет исполнителя")
    ResponseEntity<?> addExecutor(@RequestBody ExecutorDTO executorDTO);

    @DeleteMapping("/{id}")
    @Operation(summary = "удаляет исполнителя")
    ResponseEntity<?> deleteExecutor(@PathVariable Long id);

    @GetMapping
    @Operation(summary = " возвращает список исполнителей")
    List<ExecutorDTO> getAllExecutor();

    @GetMapping("/{id}")
    @Operation(summary = "возвращает исполнителя по идентификатору")
    public ExecutorDTO getExecutor(@Parameter(name = "id пользователя") @PathVariable Long id);
}
