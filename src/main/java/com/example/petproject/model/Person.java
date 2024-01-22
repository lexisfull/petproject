package com.example.petproject.model;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "Person")
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "age")
    int age;

    @Column(name = "commit")
    String commit;

    @OneToMany(mappedBy = "personId")
    List<Measurments> measurmentsList;

    @ManyToMany(mappedBy = "persons")
    List<Executor> executors;

    @OneToMany(mappedBy = "personId")
    List<Recommendation> recommendationList;

    @OneToMany(mappedBy = "personId")
    List<Eating> eatings;

    @OneToMany(mappedBy = "personId")
    List<Analysis> analysisList;
}
