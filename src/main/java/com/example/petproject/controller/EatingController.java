package com.example.petproject.controller;

import com.example.petproject.dto.EatingDTO;
import com.example.petproject.model.Person;
import com.example.petproject.service.EatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/eating")
@RestController
@RequiredArgsConstructor
public class EatingController {

    private final EatingService eatingService;

    @PostMapping
    public void addEating(@RequestBody EatingDTO eatingDTO){
        eatingService.addEating(eatingDTO);
    }

    @DeleteMapping
    public void deleteEating(Long id){
        eatingService.deleteEating(id);
    }

    @GetMapping("/{id}")
    public List<EatingDTO> getEatingPersonId(Person personId){
        return eatingService.getEatingPerson(personId);
    }
}
