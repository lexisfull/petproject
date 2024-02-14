package com.example.petproject.dto;

import com.example.petproject.model.Person;
import com.example.petproject.model.Product;
import jakarta.persistence.Column;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EatingDTO {

    Long id;

    String mealTime;

    String reasonEating;

    String withWom;

    LocalDateTime dateTime;

    List<ProductDTO> productsDTOlist;
}
