package com.example.petproject.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.Date;

@Entity
@Table(name = "Analysis")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Analysis {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    Person person_id;


    @Column(name = "result")
    String resultAnalyses;

    @Column(name = "subscribed_on")
    Date subscribedOn;


}
