package com.example.petproject.model;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name = "Executor")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Executor {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "experience")
    private int experience;

    @Column(name = "type")
    private Type type;



    @ManyToMany
    @JoinTable(
            name = "person_executor",
            joinColumns = @JoinColumn(name = "executor_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id")

    )
    private List<Person> persons;
}
