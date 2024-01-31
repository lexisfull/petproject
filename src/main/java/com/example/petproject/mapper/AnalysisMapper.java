package com.example.petproject.mapper;

import com.example.petproject.dto.AnalysisDTO;
import com.example.petproject.model.Analysis;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AnalysisMapper {

    AnalysisDTO toDTO(Analysis analysis);
    Analysis toAnalysis(AnalysisDTO analysisDTO);
}
