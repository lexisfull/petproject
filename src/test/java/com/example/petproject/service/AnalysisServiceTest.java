package com.example.petproject.service;

import com.example.petproject.dao.AnalysisRepository;
import com.example.petproject.dao.PersonRepository;
import com.example.petproject.dto.AnalysisDTO;
import com.example.petproject.factory.TestObjectFactory;
import com.example.petproject.mapper.AnalysisMapper;
import com.example.petproject.model.Analysis;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.example.petproject.factory.TestObjectFactory.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.nullable;

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
        AnalysisDTO analysisDTO = buildAnalysisDTO();
        Mockito.when(analysisMapper.toAnalysis(analysisDTO))
                .thenReturn(buildListAnalysis().get(0));
        Mockito.when(personRepository.findById(any()))
                .thenReturn(Optional.of(buildPerson()));

        analysisService.saveAnalysis(analysisDTO);

        Mockito.verify(analysisRepository, Mockito.times(1)).save(any());
    }

    @Test
    void deleteAnalysisTest() {
        Analysis analysis = buildAnalysis();
        Mockito.when(analysisRepository.findById(analysis.getId()))
                .thenReturn(any());

        analysisService.deleteAnalysis(analysis.getId());

        Mockito.verify(analysisRepository, Mockito.times(1));
    }
}