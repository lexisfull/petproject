package com.example.petproject.service;

import com.example.petproject.dao.MeasurmentsRepository;
import com.example.petproject.dao.PersonRepository;
import com.example.petproject.dto.MeasurmentsDTO;
import com.example.petproject.mapper.MeasurmentsMapper;
import com.example.petproject.model.Measurments;
import com.example.petproject.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MeasurmentsService {

    private final MeasurmentsRepository measurmentsRepository;

    private final PersonRepository personRepository;

    private final MeasurmentsMapper measurmentsMapper;

    public void addMeasurments(MeasurmentsDTO measurmentsDTO){
        var measurments = measurmentsMapper.toMeasurments(measurmentsDTO);
        var person = personRepository.findById(measurmentsDTO.getPersonId()).orElseThrow();
        measurments.setPerson(person);
        measurmentsRepository.save(measurments);
    }

    public void deleteMeasurments(Long id){
        measurmentsRepository.deleteById(id);
    }

    public List<MeasurmentsDTO> getMeasurmentsPersonId(Long personId){
       return measurmentsRepository.findAllByPersonId(personId).stream()
               .map(measurmentsMapper::toDTO)
               .collect(Collectors.toList());
    }


}
