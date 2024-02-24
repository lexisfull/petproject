package com.example.petproject.controller.api;

import com.example.petproject.controller.ExecutorController;
import com.example.petproject.dto.ExecutorDTO;
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
public class ExecutorAPI implements ExecutorController {

    final ExecutorService executorService;

    @Override
    public ResponseEntity<?> addExecutor(@RequestBody ExecutorDTO executorDTO){
        executorService.addExecutor(executorDTO);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> deleteExecutor(@PathVariable Long id){
        executorService.deleteExecutor(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public List<ExecutorDTO> getAllExecutor(){
        return executorService.getAllExecutor();
    }

    @Override
    public ExecutorDTO getExecutor(@Parameter(name = "id пользователя") @PathVariable Long id){
        return executorService.getExecutorById(id);
    }

}
