package com.example.petproject.dto;

import jakarta.persistence.Column;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RecommendationDTO {

    Long id;

    String recommendation;

    Date dateRecommendation;
}
