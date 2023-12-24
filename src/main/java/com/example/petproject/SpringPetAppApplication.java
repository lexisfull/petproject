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
		Configuration configuration = new Configuration().addAnnotatedClass(Person.class)
				.addAnnotatedClass(Executor.class);

		SessionFactory sessionFactory = configuration.buildSessionFactory();

		try (sessionFactory){
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();

			Executor executor = new Executor("Петя", 25);
			Person person = new Person("Нина", 30);
			Person person1 = new Person("Вася", 18);

			executor.setPersons(new ArrayList<>(List.of(person, person1)));

			person1.setExecutors(Collections.singletonList(executor));
			person.setExecutors(Collections.singletonList(executor));

			session.save(executor);
			session.save(person1);
			session.save(person);

			session.getTransaction().commit();


		}
	}

}
