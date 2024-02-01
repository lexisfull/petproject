package com.example.petproject.dto;

import com.example.petproject.model.Person;
import jakarta.persistence.Column;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EatingDTO {

    String mealTime;

    String reasonEating;

    String withWom;

    LocalDateTime dateTime;
}
