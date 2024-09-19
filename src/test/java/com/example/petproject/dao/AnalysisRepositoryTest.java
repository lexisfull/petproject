package com.example.petproject.dao;

import com.example.petproject.model.Analysis;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@DataJpaTest
@Testcontainers

class AnalysisRepositoryTest {

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgres =
            new PostgreSQLContainer<>("postgres:15.2-alpine")
                    .withUsername("dummy")
                    .withPassword("dummy");

    @Autowired
    private AnalysisRepository analysisRepository;

    @Test
    public void repositoryTest() {

        Analysis analysis = new Analysis();
        analysis.setResultAnalyses("result");

        analysisRepository.save(analysis);

        Assertions.assertThat(analysis).isNotNull();

    }
}
