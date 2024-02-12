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
    Integer height;

    @Column(name = "weight")
    Integer weight;

    @Column(name = "waist")
    Integer waist;

    @Column(name = "breast")
    Integer breast;

    @Column(name = "biceps")
    Integer biceps;

    @Column(name = "data")
    LocalDate data;
}
