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
    public ResponseEntity<?> addExecutor(@RequestBody ExecutorDTO executorDTO){
        executorService.addExecutor(executorDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "удаляет исполнителя")
    public HttpStatus deleteExecutor(@PathVariable Long id){
        executorService.deleteExecutor(id);
        return HttpStatus.OK;
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
