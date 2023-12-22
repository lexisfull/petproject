package com.example.petproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Person")
public class Person {
    private int id;
    private String name;
    private int age;
}
