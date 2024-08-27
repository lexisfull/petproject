package com.example.petproject.dao;

import com.example.petproject.container.TestContainer;
import com.example.petproject.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace= Replace.NONE)
@Testcontainers
class PersonRepositoryTest extends TestContainer {

//    @Container
//    @ServiceConnection
//    static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer("postgres:latest");

    @Autowired
    private PersonRepository personRepository;

    @BeforeEach
    public void setUp() {
        personRepository.deleteAll();
    }

    @Test
    public void givenPerson_whenSave_thenCreataPerson() {
        //Give
        Person person = Person.builder()
                .name("Vova")
                .age(22)
                .build();
        //When
        Person savePerson = personRepository.save(person);
        //Then
        assertThat(savePerson).isNotNull();
        assertThat(savePerson.getId()).isNotNull();

    }
}