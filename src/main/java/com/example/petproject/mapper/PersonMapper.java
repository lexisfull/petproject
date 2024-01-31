package com.example.petproject.mapper;


import com.example.petproject.dto.PersonDTO;
import com.example.petproject.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {AnalysisListMapper.class})
public interface PersonMapper {
    @Mapping(source = "person.analysisList", target = "analysisDTOList")
    PersonDTO toDTO(Person person);

    @Mapping(target = "analysisDTOList", ignore = true)
    PersonDTO toDTONotAnalysis(Person person);

    @Mapping(source = "personDTO.analysisDTOList", target = "analysisList")
    Person toPerson(PersonDTO personDTO);
}
