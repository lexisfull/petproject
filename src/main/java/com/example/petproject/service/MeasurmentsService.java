package com.example.petproject.service;

import com.example.petproject.dao.MeasurmentsRepository;
import com.example.petproject.dto.MeasurmentsDTO;
import com.example.petproject.model.Measurments;
import com.example.petproject.model.Person;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MeasurmentsService {

    private final MeasurmentsRepository measurmentsRepository;

    private final ModelMapper modelMapper;

    public void addMeasurments(MeasurmentsDTO measurmentsDTO){
        measurmentsRepository.save(convertToMesurments(measurmentsDTO));
    }

    public void deleteMeasurments(Long id){
        measurmentsRepository.deleteById(id);
    }

    public List<MeasurmentsDTO> getMeasurmentsPersonId(Person personId){
       return measurmentsRepository.findByPersonId(personId).stream()
               .map(this::convertToMeasurmentsDTO)
               .collect(Collectors.toList());
    }

    private MeasurmentsDTO convertToMeasurmentsDTO(Measurments measurments){
        return modelMapper.map(measurments, MeasurmentsDTO.class);
    }
    private Measurments convertToMesurments(MeasurmentsDTO measurmentsDTO){
        return modelMapper.map(measurmentsDTO, Measurments.class);
    }
}
