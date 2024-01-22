package com.example.petproject.service;

import com.example.petproject.dao.EatingRepository;
import com.example.petproject.dto.EatingDTO;
import com.example.petproject.model.Eating;
import com.example.petproject.model.Person;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EatingService {

    private final EatingRepository eatingRepository;

    private final ModelMapper modelMapper;

    public List<EatingDTO> getEatingPerson(Person personId){
        return eatingRepository.findByPersonIdOrderByDateTime(personId)
                .stream().map(this::convertEatingDTO)
                .collect(Collectors.toList());
    }

    public void addEating(EatingDTO eatingDTO){
        eatingRepository.save(convertEating(eatingDTO));
    }

    public void deleteEating(Long id){
        eatingRepository.deleteById(id);
    }

    private EatingDTO convertEatingDTO(Eating eating){
        return modelMapper.map(eating, EatingDTO.class);
    }

    private Eating convertEating(EatingDTO eatingDTO){
        return modelMapper.map(eatingDTO, Eating.class);
    }
}
