package com.example.petproject.mapper;

import com.example.petproject.dto.MeasurmentsDTO;
import com.example.petproject.model.Measurments;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MeasurmentsMapper {

    @Mapping(source = "person.id", target = "person")
    MeasurmentsDTO toDTO(Measurments measurments);

    @Mapping(target = "person", ignore = true)
    Measurments toMeasurments(MeasurmentsDTO measurmentsDTO);
}
