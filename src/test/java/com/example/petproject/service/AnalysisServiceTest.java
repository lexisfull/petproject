package com.example.petproject.service;

import com.example.petproject.dao.AnalysisRepository;
import com.example.petproject.dao.PersonRepository;
import com.example.petproject.dto.AnalysisDTO;
import com.example.petproject.mapper.AnalysisMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.example.petproject.factory.TestObjectFactory.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

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
        var list = buildListAnalysis();
        var dto = buildAnalysisDTO();
        when(analysisRepository.findAll())
                .thenReturn(list);
        when(analysisMapper.toDTO(any()))
                .thenReturn(dto);

        analysisService.getAllAnalysis();

        verify(analysisRepository).findAll();
    }

    @Test
    void shouldGet_AllAnalysis_PersonTest() {
        var list = buildListAnalysis();
        var dto = buildAnalysisDTO();
        when(analysisRepository.findAllByPersonId(1L))
                .thenReturn(list);
        when(analysisMapper.toDTO(any()))
                .thenReturn(dto);

        analysisService.getAllAnalysisPerson(1L);

        verify(analysisRepository).findAllByPersonId(1L);
    }

    @Test
    void shouldSave_AnalysisTest() {
        AnalysisDTO analysisDTO = buildAnalysisDTO();
        when(analysisMapper.toAnalysis(analysisDTO))
                .thenReturn(buildListAnalysis().get(0));
        when(personRepository.findById(any()))
                .thenReturn(Optional.of(buildPerson()));

        analysisService.saveAnalysis(analysisDTO);

        verify(analysisRepository, times(1)).save(any());
    }

    @Test
    void shouldDelete_oneAnalysis() {
        doNothing().when(analysisRepository).deleteById(anyLong());

        analysisService.deleteAnalysis(anyLong());
        verify(analysisRepository, times(1))
                .deleteById(anyLong());
        verifyNoMoreInteractions(analysisRepository);
    }
}