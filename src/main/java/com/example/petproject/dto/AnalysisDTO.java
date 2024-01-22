package com.example.petproject.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AnalysisDTO {

    String resultAnalyses;
    Long personId;
}
