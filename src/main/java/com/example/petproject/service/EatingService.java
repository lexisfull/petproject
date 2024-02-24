package com.example.petproject.service;

import com.example.petproject.dto.EatingDTO;

import java.util.List;

public interface EatingService {

    List<EatingDTO> getEatingPerson(Long personId);

    void addEating(EatingDTO eatingDTO);

    void deleteEating(Long id);


}
