package com.example.petproject.controller;

import com.example.petproject.dto.MeasurmentsDTO;
import com.example.petproject.service.MeasurmentsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/measurments")
@RestController
@RequiredArgsConstructor
@Tag(name = "для работы с замерами пользователя")
public class MeasurmentsController {

    private final MeasurmentsService measurmentsService;

    @PostMapping
    @Operation(summary = "добавляет замеры по идентификатору пользователя")
    public ResponseEntity<?> addMeasurments(@RequestBody MeasurmentsDTO measurmentsDTO){
        measurmentsService.addMeasurments(measurmentsDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "удаляет замеры по идентификатору")
    public void deleteMeasurments(@PathVariable Long id){
        measurmentsService.deleteMeasurments(id);
    }

    @GetMapping("/{personId}")
    @Operation(summary = "возвращает все замеры по идентификатору пользователя")
    public List<MeasurmentsDTO> getMeasurmentsPerson(@PathVariable Long personId){
        return  measurmentsService.getMeasurmentsPersonId(personId);
    }
}
