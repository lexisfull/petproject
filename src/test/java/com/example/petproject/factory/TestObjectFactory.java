package com.example.petproject.factory;

import com.example.petproject.dto.AnalysisDTO;
import com.example.petproject.dto.EatingDTO;
import com.example.petproject.dto.ExecutorDTO;
import com.example.petproject.dto.MeasurmentsDTO;
import com.example.petproject.dto.PersonDTO;
import com.example.petproject.model.Analysis;
import com.example.petproject.model.Eating;
import com.example.petproject.model.Executor;
import com.example.petproject.model.Measurments;
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
                .subscribedOn(LocalDate.of(2024, 2, 3))
                .build();
    }

    public static List<Analysis> buildListAnalysis(){
        Person person1 = buildPerson();
        person1.setId(1L);
        Analysis analysis = Analysis.builder()
                .id(1L)
                .person(person1)
                .resultAnalyses("analysis")
                .subscribedOn(LocalDate.of(2024, 2, 3))
                .build();
        Analysis analysis2 = Analysis.builder()
                .id(2L)
                .person(person1)
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
        return Analysis.builder()
                .id(1L)
                .person(person)
                .resultAnalyses("analysis")
                .subscribedOn(LocalDate.of(2024, 2, 3))
                .build();

    }

    public static Person buildPerson(){
        return Person.builder()
                .id(1L)
                .name("Vova")
                .build();
    }

    public static Eating buildEating(){
        return Eating.builder()
                .id(1L)
                .person(null)
                .dateTime(LocalDate.of(2024, 2, 3).atTime(15, 0))
                .build();
    }

    public static EatingDTO buildEatingDTO(){
        return EatingDTO.builder()
                .id(1L)
                .personId(1L)
                .dateTime(LocalDate.of(2024, 2, 3).atTime(15, 0))
                .build();
    }

    public static List<EatingDTO> buildListEatingDTO(){
        EatingDTO eatingDTO1 = buildEatingDTO();
        EatingDTO eatingDTO2 = buildEatingDTO();
        eatingDTO2.setId(2L);
        eatingDTO2.setPersonId(2L);
        List<EatingDTO> eatingDTOList = new ArrayList<>();
        eatingDTOList.add(eatingDTO1);
        eatingDTOList.add(eatingDTO2);
        return eatingDTOList;
    }

    public static ExecutorDTO buildExecutor(){

        return ExecutorDTO.builder()
                .id(1L)
                .age(35)
                .name("Masha")
                .experience(5)
                .build();

    }

    public static List<ExecutorDTO> buildListExecutor(){

        ExecutorDTO executorDTO1 = buildExecutor();
        ExecutorDTO executorDTO2 = buildExecutor();
        executorDTO2.setId(2L);
        executorDTO2.setName("Sasha");
        executorDTO2.setAge(30);
        executorDTO2.setExperience(4);
        List<ExecutorDTO> executorDTOList = new ArrayList<>();
        executorDTOList.add(executorDTO1);
        executorDTOList.add(executorDTO2);

        return executorDTOList;
    }

    public static MeasurmentsDTO buildMeasurmentsDTO(){
        return MeasurmentsDTO.builder()
                .id(1L)
                .height(175)
                .weight(80)
                .build();
    }

    public static List<MeasurmentsDTO> buildListMeasurmentsDTO(){
        MeasurmentsDTO measurmentsDTO1 = buildMeasurmentsDTO();
        MeasurmentsDTO measurmentsDTO2 = buildMeasurmentsDTO();
        measurmentsDTO2.setId(2L);
        measurmentsDTO2.setHeight(170);
        measurmentsDTO2.setWeight(95);

        List<MeasurmentsDTO> measurmentsDTOList = new ArrayList<>(){{
            add(measurmentsDTO1);
            add(measurmentsDTO2);
        }};

        return measurmentsDTOList;
    }

    public static PersonDTO buildPersonDTO(){
        return PersonDTO.builder()
                        .id(1L)
                        .name("Vova")
                        .age(35)
                        .build();
    }

    public static List<PersonDTO> buildListPersonDTO(){
        PersonDTO personDTO1 = buildPersonDTO();
        PersonDTO personDTO2 = buildPersonDTO();
        personDTO2.setId(2L);
        personDTO2.setName("Sasha");
        List<PersonDTO> personDTOList = new ArrayList<>(){{
           add(personDTO1);
           add(personDTO2);
        }};
        return personDTOList;
    }

}
