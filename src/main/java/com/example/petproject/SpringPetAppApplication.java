package com.example.petproject;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@Slf4j
@SpringBootApplication
public class SpringPetAppApplication {

	public static void main(String[] args) {
		log.info("launching the application");
		SpringApplication.run(SpringPetAppApplication.class, args);
	}

}
