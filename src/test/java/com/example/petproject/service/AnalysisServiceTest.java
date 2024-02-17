package com.example.petproject.service;

import com.example.petproject.dao.AnalysisRepository;
import com.example.petproject.dao.PersonRepository;
import com.example.petproject.dto.AnalysisDTO;
import com.example.petproject.factory.TestObjectFactory;
import com.example.petproject.mapper.AnalysisMapper;
import com.example.petproject.model.Analysis;
import com.example.petproject.model.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class AnalysisServiceTest {

    @Mock
    private AnalysisMapper analysisMapper;

    @Mock
    private PersonRepository personRepository;

    @Mock
    private AnalysisRepository analysisRepository;

    @InjectMocks
    private AnalysisService analysisService;

    @Test
    void getAllAnalysisTest() {

    }

    @Test
    void getAllAnalysisPersonTest() {
    }

    @Test
    void saveAnalysisTest() {
        AnalysisDTO analysisDTO = TestObjectFactory.buildAnalysisDTO();
        Mockito.when(analysisMapper.toAnalysis(analysisDTO)).thenReturn(TestObjectFactory.buildAnalysis());
        Mockito.when(personRepository.findById(any())).thenReturn(Optional.of(TestObjectFactory.buildPerson()));

        analysisService.saveAnalysis(analysisDTO);

        Mockito.verify(analysisRepository, Mockito.times(1)).save(any());
    }

    @Test
    void deleteAnalysisTest() {
    }
}