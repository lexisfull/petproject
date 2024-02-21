package com.example.petproject.dto;

import com.example.petproject.model.Executor;
import com.example.petproject.model.Person;
import com.example.petproject.model.Type;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExecutorDTO {

    Long id;

    Long person;

    String name;

    Integer age;

    Integer experience;

    Type type;


    List<PersonDTO> personDTOList;


    List<ExecutorDTO> executorDTOList;
}
