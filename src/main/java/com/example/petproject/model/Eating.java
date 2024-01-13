package com.example.petproject.model;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
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
    long id;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    Person person_id;

    @Column(name = "mealTime")
    String mealTime;

    @Column(name = "reasonEating")
    String reasonEating;

    @Column(name = "withWom")
    String withWom;

    @OneToMany(mappedBy = "eat")
    List<Product> products;

}
