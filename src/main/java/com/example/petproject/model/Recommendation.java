package com.example.petproject.model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AccessLevel;
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
    Long id;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    Person personId;

    @ManyToOne
    @JoinColumn(name = "executor_id", referencedColumnName = "id")
    Executor executorId;

    @Column(name = "recommendation")
    String recommendation;

    @Column(name = "dateRecommedation")
    Date dateRecommendation;
}
