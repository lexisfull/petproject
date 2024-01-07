package com.example.petproject;

import com.example.petproject.model.Executor;
import com.example.petproject.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class SpringPetAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringPetAppApplication.class, args);

	}

}
