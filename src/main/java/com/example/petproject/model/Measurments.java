package com.example.petproject.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Table(name = "Measurments")
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class Measurments {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    Person person_id;

    @Column(name = "waist")
    int waist;

    @Column(name = "breast")
    int breast;

    @Column(name = "biceps")
    int biceps;

    @Column(name = "data")
    LocalDate data;
}
