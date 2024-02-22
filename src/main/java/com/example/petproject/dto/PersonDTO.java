package com.example.petproject.dto;


import com.example.petproject.model.*;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PersonDTO {

    Long id;

    String name;

    Integer age;

    String commit;

    List<MeasurmentsDTO> measurmentsDTOList;

    List<ExecutorDTO> executorDTOList;

    List<RecommendationDTO> recommendationDTOList;

    List<EatingDTO> eatingDTOList;

    List<AnalysisDTO> analysisDTOList;
}
