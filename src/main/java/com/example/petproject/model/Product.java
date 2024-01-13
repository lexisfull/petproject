package com.example.petproject.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "Product")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne
    @JoinColumn(name = "eat_id", referencedColumnName = "id")
    Eating eat;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "protein", nullable = false)
    int protein;

    @Column(name = "fat", nullable = false)
    int fat;

    @Column(name = "carbohydrates", nullable = false)
    int carbohydrates;

    @Column(name = "kcal", nullable = false)
    int kcal;


}
