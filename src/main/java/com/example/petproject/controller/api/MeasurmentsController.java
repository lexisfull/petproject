package com.example.petproject.controller.api;

import com.example.petproject.dto.MeasurmentsDTO;
import com.example.petproject.service.MeasurmentsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/measurments")
@RestController
@RequiredArgsConstructor
@Tag(name = "для работы с замерами пользователя")
public class MeasurmentsController implements com.example.petproject.controller.MeasurmentsAPI {

    private final MeasurmentsService measurmentsService;

    @Override
    public ResponseEntity<?> addMeasurments(@RequestBody MeasurmentsDTO measurmentsDTO){
        measurmentsService.addMeasurments(measurmentsDTO);
        return ResponseEntity.ok().build();
    }

    @Override
    public void deleteMeasurments(@PathVariable Long id){
        measurmentsService.deleteMeasurments(id);
    }

    @Override
    public List<MeasurmentsDTO> getMeasurmentsPerson(@PathVariable Long personId){
        return  measurmentsService.getMeasurmentsPersonId(personId);
    }
}
