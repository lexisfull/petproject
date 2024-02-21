package com.example.petproject.service;

import com.example.petproject.dao.EatingRepository;
import com.example.petproject.dao.PersonRepository;
import com.example.petproject.dto.EatingDTO;
import com.example.petproject.mapper.EatingMapper;
import com.example.petproject.model.Eating;
import com.example.petproject.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EatingService {

    private final EatingRepository eatingRepository;

    private final PersonRepository personRepository;

    private final EatingMapper eatingMapper;

    public List<EatingDTO> getEatingPerson(Person person){
        return eatingRepository.findByPersonIdOrderByDateTime(person)
                .stream().map(eatingMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void addEating(EatingDTO eatingDTO){
        var eating = eatingMapper.toEating(eatingDTO);
        var person = personRepository.findById(eatingDTO.getPerson()).orElseThrow();
        eating.setPerson(person);
        eatingRepository.save(eating);
    }

    public void deleteEating(Long id){
        eatingRepository.deleteById(id);
    }

}
