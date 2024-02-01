package com.example.petproject.controller;

import com.example.petproject.dto.ExecutorDTO;
import com.example.petproject.model.Executor;
import com.example.petproject.service.ExecutorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/executor")
@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Tag(name = "Исполнители", description = "методы работы с исполнителями")
public class ExecutorController {

    final ExecutorService executorService;

    @PostMapping
    @Operation(summary = "добавляет исполнителя")
    public ResponseEntity<Executor> addExecutor(ExecutorDTO executorDTO){
        return new ResponseEntity<>(executorService.addExecutor(executorDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "удаляет исполнителя")
    public void deleteExecutor(@PathVariable Long id){
        executorService.deleteExecutor(id);
    }

    @GetMapping
    @Operation(summary = " возвращает список исполнителей")
    public List<ExecutorDTO> getAllExecutor(){
        return executorService.getAllExecutor();
    }

    @GetMapping("/{id}")
    @Operation(summary = "возвращает исполнителя по идентификатору")
    public ExecutorDTO getExecutor(@Parameter(name = "id пользователя") @PathVariable Long id){
        return executorService.getExecutorById(id);
    }

}
