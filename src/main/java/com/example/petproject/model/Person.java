package com.example.petproject.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "Person")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "age")
    int age;

    @Column(name = "height")
    int height;

    @Column(name = "weight")
    int weight;

    @Column(name = "commit")
    String commit;

    @OneToMany(mappedBy = "person_id")
    List<Measurments> measurmentsList;

    @ManyToMany(mappedBy = "persons")
    List<Executor> executors;

    @OneToMany(mappedBy = "person_id")
    List<Recommendation> recommendationList;

    @OneToMany(mappedBy = "person_id")
    List<Eating> eatings;

    @OneToMany(mappedBy = "person_id")
    List<Analysis> analysisList;

}
