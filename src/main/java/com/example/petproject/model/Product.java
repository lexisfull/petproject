package com.example.petproject.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {
    String name;
    int protein;
    int fat;
    int carbohydrates;
    int kcal;
}
