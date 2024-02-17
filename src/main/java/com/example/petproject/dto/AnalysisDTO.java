package com.example.petproject.dto;

import com.example.petproject.model.Person;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AnalysisDTO {
    
    Long id;

    Long personId;

    String resultAnalyses;

    LocalDate subscribedOn;
}
