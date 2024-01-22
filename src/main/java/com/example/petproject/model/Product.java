package com.example.petproject.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
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
    Long id;

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
