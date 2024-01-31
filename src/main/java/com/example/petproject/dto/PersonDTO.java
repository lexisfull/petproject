package com.example.petproject.dto;


import com.example.petproject.model.*;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PersonDTO {

    String name;

    int age;

    String commit;

//    Person personId;


//    List<Measurments> measurmentsList;
//
//
//    List<Executor> executors;
//
//
//    List<Recommendation> recommendationList;
//
//
//    List<Eating> eatings;


    List<AnalysisDTO> analysisDTOList;
}
