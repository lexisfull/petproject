package com.example.petproject.mapper;

import com.example.petproject.dto.MeasurmentsDTO;
import com.example.petproject.model.Measurments;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {MeasurmentsMapper.class})
public interface MeasurmentsListMapper {

    List<MeasurmentsDTO> toDTO(List<Measurments> measurmentsList);

    List<Measurments> toMeasurments(List<MeasurmentsDTO> measurmentsDTOList);
}
