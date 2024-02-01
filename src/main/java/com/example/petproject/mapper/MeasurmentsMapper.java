package com.example.petproject.mapper;

import com.example.petproject.dto.MeasurmentsDTO;
import com.example.petproject.model.Measurments;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MeasurmentsMapper {

    MeasurmentsDTO toDTO(Measurments measurments);

    Measurments toMeasurments(MeasurmentsDTO measurmentsDTO);
}
