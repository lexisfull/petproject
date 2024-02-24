package com.example.petproject.service;

import com.example.petproject.dto.AnalysisDTO;

import java.util.List;

public interface AnalysisService {

    List<AnalysisDTO> getAllAnalysis();

    List<AnalysisDTO> getAllAnalysisPerson(Long personId);

    void saveAnalysis(AnalysisDTO analysisDTO);

    void deleteAnalysis(Long id);

}
