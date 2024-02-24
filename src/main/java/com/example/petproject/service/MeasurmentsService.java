package com.example.petproject.service;

import com.example.petproject.dto.MeasurmentsDTO;

import java.util.List;

public interface MeasurmentsService {

    void addMeasurments(MeasurmentsDTO measurmentsDTO);

    void deleteMeasurments(Long id);

    List<MeasurmentsDTO> getMeasurmentsPersonId(Long personId);
}
