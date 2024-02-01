package com.example.petproject.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "person")
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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    List<Measurments> measurmentsList;

    @ManyToMany(mappedBy = "persons")
    List<Executor> executors;

    @OneToMany(mappedBy = "personId", cascade = CascadeType.ALL)
    List<Recommendation> recommendationList;

    @OneToMany(mappedBy = "personId", cascade = CascadeType.ALL)
    List<Eating> eatingList;

    @OneToMany(mappedBy = "personId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Analysis> analysisList;
}
