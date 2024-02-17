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
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    Person personId;

    @Column(name = "mealTime")
    String mealTime;

    @Column(name = "reasonEating")
    String reasonEating;

    @Column(name = "withWom")
    String withWom;

    @Column(name = "dateTime")
    LocalDate dateTime;

    @OneToMany(mappedBy = "eat")
    List<Product> products;

}
