package com.example.petproject.dto;

import com.example.petproject.model.Person;
import jakarta.persistence.Column;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MeasurmentsDTO {

    Integer height;

    Integer weight;

    Integer waist;

    Integer breast;

    Integer biceps;

    LocalDate data;

}
