package com.example.petproject.factory;

import com.example.petproject.dto.AnalysisDTO;
import com.example.petproject.model.Analysis;
import com.example.petproject.model.Person;

import java.time.LocalDate;

public class TestObjectFactory {
    public static AnalysisDTO buildAnalysisDTO(){
        return AnalysisDTO.builder()
                .id(1L)
                .personId(1L)
                .resultAnalyses("analysis")
                .subscribedOn(LocalDate.of(2024, 02, 03))
                .build();
    }

    public static Analysis buildAnalysis(){
        return Analysis.builder()
                .id(1L)
                .personId(null)
                .resultAnalyses("analysis")
                .subscribedOn(LocalDate.of(2024, 02, 03))
                .build();
    }

    public static Person buildPerson(){
        return Person.builder()
                .id(1L)
                .name("Vova")
                .build();
    }

}
