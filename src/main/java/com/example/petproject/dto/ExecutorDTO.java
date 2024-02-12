package com.example.petproject.dto;

import com.example.petproject.model.Type;
import jakarta.persistence.Column;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExecutorDTO {

    private String name;

    private Integer age;

    private Integer experience;

    private Type type;
}
