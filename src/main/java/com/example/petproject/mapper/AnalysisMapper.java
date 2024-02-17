package com.example.petproject.mapper;

import com.example.petproject.dto.AnalysisDTO;
import com.example.petproject.model.Analysis;
import com.example.petproject.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.Qualifier;

@Mapper(componentModel = "spring")
public interface AnalysisMapper {

    @Mapping(source = "personId.id", target = "personId")
    AnalysisDTO toDTO(Analysis analysis);

//    @Named("getPersonId")
//    default Long getPersonId(Person personId){
//        return personId.getId();
//    }

    @Mapping(target = "personId", ignore = true)
    Analysis toAnalysis(AnalysisDTO analysisDTO);

}
