package com.example.petproject.dto;

import com.example.petproject.model.Person;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AnalysisDTO {
    
    Long id;

    Long personId;

    String resultAnalyses;

    Date  subscribedOn;
}
