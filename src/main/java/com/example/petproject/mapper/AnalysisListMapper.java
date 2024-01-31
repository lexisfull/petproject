package com.example.petproject.mapper;

import com.example.petproject.dto.AnalysisDTO;
import com.example.petproject.model.Analysis;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {AnalysisMapper.class})
public interface AnalysisListMapper {

    List<AnalysisDTO> toAnalysisDTOList(List<Analysis> analysis);

    List<Analysis> toAnalysisList(List<AnalysisDTO> analysisDTOList);
}
