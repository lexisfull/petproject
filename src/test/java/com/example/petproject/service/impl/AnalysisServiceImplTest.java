package com.example.petproject.service.impl;

import com.example.petproject.dao.AnalysisRepository;
import com.example.petproject.dao.PersonRepository;
import com.example.petproject.dto.AnalysisDTO;
import com.example.petproject.mapper.AnalysisMapper;
import com.example.petproject.service.impl.AnalysisServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.example.petproject.factory.TestObjectFactory.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class AnalysisServiceImplTest {

    @Mock
    private AnalysisMapper analysisMapper;

    @Mock
    private PersonRepository personRepository;

    @Mock
    private AnalysisRepository analysisRepository;

    @InjectMocks
    private AnalysisServiceImpl analysisService;

    @Test
    void shouldGet_AllAnalysis_Test() {
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
    void shouldSave_Analysis_Test() {
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