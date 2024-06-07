package com.example.petproject.controller;

import com.example.petproject.dto.MeasurmentsDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface MeasurmentsAPI {

    @PostMapping
    @Operation(summary = "добавляет замеры по идентификатору пользователя")
    ResponseEntity<?> addMeasurments(@RequestBody MeasurmentsDTO measurmentsDTO);

    @DeleteMapping("/{id}")
    @Operation(summary = "удаляет замеры по идентификатору")
    void deleteMeasurments(@PathVariable Long id);

    @GetMapping("/{personId}")
    @Operation(summary = "возвращает все замеры по идентификатору пользователя")
    List<MeasurmentsDTO> getMeasurmentsPerson(@PathVariable Long personId);
}
