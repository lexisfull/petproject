package com.example.petproject.dto;

import com.example.petproject.model.Person;
import com.example.petproject.model.Type;
import jakarta.persistence.Column;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExecutorDTO {

    Long id;

    String name;

    Integer age;

    Integer experience;

    Type type;

    List<PersonDTO> personDTOList;
}
