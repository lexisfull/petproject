package com.example.petproject.dto;

import jakarta.persistence.Column;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDTO {

    String name;

    Integer protein;

    Integer fat;

    Integer carbohydrates;

    Integer kcal;
}
