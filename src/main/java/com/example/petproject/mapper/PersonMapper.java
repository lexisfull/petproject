package com.example.petproject.mapper;


import com.example.petproject.dto.PersonDTO;
import com.example.petproject.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {AnalysisListMapper.class, EatingListMapper.class})
public interface PersonMapper {
    @Mapping(source = "person.analysisList", target = "analysisDTOList")
    @Mapping(source = "person.eatingList", target = "eatingDTOList")
    PersonDTO toDTO(Person person);

    @Mapping(target = "analysisDTOList", ignore = true)
    @Mapping(target = "eatingDTOList", ignore = true)
    PersonDTO toDTONotAnalysis(Person person);

    @Mapping(source = "personDTO.analysisDTOList", target = "analysisList")
    @Mapping(source = "personDTO.eatingDTOList", target = "eatingList")
    Person toPerson(PersonDTO personDTO);

    @Mapping(target = "analysisList", ignore = true)
    @Mapping(target = "eatingList", ignore = true)
    @Mapping(target = "recommendationList", ignore = true)
    @Mapping(target = "executors", ignore = true)
    @Mapping(target = "measurmentsList", ignore = true)
    Person toPersonNotList(PersonDTO personDTO);
}
