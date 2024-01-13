package com.example.petproject.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity
@Table(name = "Recomendation")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Recommendation {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    Person person_id;

    @ManyToOne
    @JoinColumn(name = "executor_id", referencedColumnName = "id")
    Executor executor_id;

    @Column(name = "recommendation")
    String recommendation;

    @Column(name = "dateRecommedation")
    Date dateRecommendation;
}
