package com.example.petproject.model;



import jakarta.persistence.*;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


import lombok.experimental.FieldDefaults;
import lombok.AccessLevel;

import java.time.LocalDate;

@Entity
@Table(name = "Measurments")
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class Measurments {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    Person personId;

    @Column(name = "height")
    int height;

    @Column(name = "weight")
    int weight;

    @Column(name = "waist")
    int waist;

    @Column(name = "breast")
    int breast;

    @Column(name = "biceps")
    int biceps;

    @Column(name = "data")
    LocalDate data;
}
