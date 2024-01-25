package com.example.petproject.controller;

import com.example.petproject.dto.MeasurmentsDTO;
import com.example.petproject.model.Person;
import com.example.petproject.service.MeasurmentsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/measurments")
@RestController
@RequiredArgsConstructor
@Tag(name = "для работы с замерами пользователя")
public class MeasurmentsController {

    private final MeasurmentsService measurmentsService;

    @PostMapping("/{personId}")
    @Operation(summary = "добавляет замеры по идентификатору пользователя")
    public void addMeasurments(@RequestBody MeasurmentsDTO measurmentsDTO, @PathVariable Person personId){
        measurmentsService.addMeasurments(measurmentsDTO);
    }

    @DeleteMapping
    @Operation(summary = "удаляет замеры по идентификатору")
    public void deleteMeasurments(Long id){
        measurmentsService.deleteMeasurments(id);
    }

    @GetMapping("measurment/{personId}")
    @Operation(summary = "возвращает все замеры по идентификатору пользователя")
    public List<MeasurmentsDTO> getMeasurmentsPerson(@PathVariable Person personId){
        return  measurmentsService.getMeasurmentsPersonId(personId);
    }
}
