package com.example.petproject.dto;

import jakarta.persistence.Column;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RecommendationDTO {

    Long id;

    Long personId;

    String recommendation;

    Date dateRecommendation;
}
