package com.example.petproject.controller.api;

import com.example.petproject.controller.EatingApi;
import com.example.petproject.dto.EatingDTO;
import com.example.petproject.service.EatingService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/eating")
@RestController
@RequiredArgsConstructor
@Tag(name = "Приемы пищи", description = "методы для приема пищи")
public class EatingController implements EatingApi {

    private final EatingService eatingService;

    @Override
    public ResponseEntity<?> addEating(@RequestBody EatingDTO eatingDTO){
        eatingService.addEating(eatingDTO);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> deleteEating(@PathVariable Long id){
        eatingService.deleteEating(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<List<EatingDTO>> getEatingPersonId(@PathVariable Long personId){
        return new ResponseEntity<>(eatingService.getEatingPerson(personId), HttpStatus.OK);
    }
}
