package com.example.petproject.model;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Eating")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Eating {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "person", referencedColumnName = "id")
    Person person;

    @Column(name = "mealTime")
    String mealTime;

    @Column(name = "reasonEating")
    String reasonEating;

    @Column(name = "withWom")
    String withWom;

    @Column(name = "dateTime")
    LocalDateTime dateTime;

    @ManyToMany
    @JoinTable(
            name = "eat_product",
            joinColumns = @JoinColumn(name = "eat"),
            inverseJoinColumns = @JoinColumn(name = "product")
    )
    List<Product> products;

}
