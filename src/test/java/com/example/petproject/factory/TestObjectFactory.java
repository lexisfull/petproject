package com.example.petproject.factory;

import com.example.petproject.dto.AnalysisDTO;
import com.example.petproject.model.Analysis;
import com.example.petproject.model.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestObjectFactory {
    public static AnalysisDTO buildAnalysisDTO(){
        return AnalysisDTO.builder()
                .id(1L)
                .personId(1L)
                .resultAnalyses("analysis")
                .subscribedOn(LocalDate.of(2024, 02, 03))
                .build();
    }

    public static List<Analysis> buildListAnalysis(){
        Person person1 = buildPerson();
        person1.setId(1L);
        Analysis analysis = Analysis.builder()
                .id(1L)
                .personId(person1)
                .resultAnalyses("analysis")
                .subscribedOn(LocalDate.of(2024, 2, 3))
                .build();
        Analysis analysis2 = Analysis.builder()
                .id(2L)
                .personId(person1)
                .resultAnalyses("analysis2")
                .subscribedOn(LocalDate.of(2024, 3, 3))
                .build();
        List<Analysis> analysisList = new ArrayList<>();
        analysisList.add(analysis);
        analysisList.add(analysis2);
        return analysisList;
    }

    public static Analysis buildAnalysis(){
        Person person = buildPerson();
        Analysis analysis = Analysis.builder()
                .id(1L)
                .personId(person)
                .resultAnalyses("analysis")
                .subscribedOn(LocalDate.of(2024, 2, 3))
                .build();
        return analysis;
    }

    public static Person buildPerson(){
        return Person.builder()
                .id(1L)
                .name("Vova")
                .build();
    }

}
