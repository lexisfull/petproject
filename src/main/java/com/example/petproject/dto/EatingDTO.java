package com.example.petproject.dto;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class EatingDTO {

    Long id;

    Long personId;

    String mealTime;

    String reasonEating;

    String withWom;

    LocalDateTime dateTime;

    List<ProductDTO> productsDTOlist;
}
