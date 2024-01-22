package com.example.petproject.dto;

import jakarta.persistence.Column;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MeasurmentsDTO {

    int height;

    int weight;

    int waist;

    int breast;

    int biceps;

    LocalDate data;
}
