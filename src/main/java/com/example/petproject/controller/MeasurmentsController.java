package com.example.petproject.controller;

import com.example.petproject.dto.MeasurmentsDTO;
import com.example.petproject.model.Person;
import com.example.petproject.service.MeasurmentsService;
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
    public void addMeasurments(@RequestBody MeasurmentsDTO measurmentsDTO, @PathVariable Person personId){
        measurmentsService.addMeasurments(measurmentsDTO);
    }

    @DeleteMapping
    public void deleteMeasurments(Long id){
        measurmentsService.deleteMeasurments(id);
    }

    @GetMapping("/{personId}")
    public List<MeasurmentsDTO> getMeasurments(@PathVariable Person personId){
        return  measurmentsService.getMeasurmentsPersonId(personId);
    }
}
