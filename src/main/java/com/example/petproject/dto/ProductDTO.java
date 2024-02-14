package com.example.petproject.dto;

import jakarta.persistence.Column;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDTO {

    Long id;

    String name;

    Double protein;

    Double fat;

    Double carbohydrates;

    Double kcal;
}
