package com.example.petproject.service.impl;

import com.example.petproject.dao.EatingRepository;
import com.example.petproject.dao.PersonRepository;
import com.example.petproject.dto.EatingDTO;
import com.example.petproject.mapper.EatingMapper;
import com.example.petproject.service.EatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EatingServiceImpl implements EatingService {

    private final EatingRepository eatingRepository;

    private final PersonRepository personRepository;

    private final EatingMapper eatingMapper;

    @Override
    public List<EatingDTO> getEatingPerson(Long personId){
        return eatingRepository.findAllByPersonId(personId)
                .stream().map(eatingMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void addEating(EatingDTO eatingDTO){
        var eating = eatingMapper.toEating(eatingDTO);
        var person = personRepository.findById(eatingDTO.getPersonId()).orElseThrow();
        eating.setPerson(person);
        eatingRepository.save(eating);
    }

    @Override
    public void deleteEating(Long id){
        eatingRepository.deleteById(id);
    }

}
