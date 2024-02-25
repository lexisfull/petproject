package com.example.petproject.service.impl;

import com.example.petproject.dao.PersonRepository;
import com.example.petproject.dao.RecommendationRepository;
import com.example.petproject.factory.TestObjectFactory;
import com.example.petproject.mapper.RecommendationMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.example.petproject.factory.TestObjectFactory.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RecommendationServiceImplTest {

    @Mock
    private RecommendationRepository recommendationRepository;

    @Mock
    private PersonRepository personRepository;

    @Mock
    private RecommendationMapper recommendationMapper;

    @InjectMocks
    private RecommendationServiceImpl recommendationService;

    @Test
    void shouldAdd_Recommendation_Test() {
        var dto = buildRecommendationDTO();
        var recommendation = buildRecommendation();
        when(recommendationMapper.toRecommendation(dto))
                .thenReturn(recommendation);
        when(personRepository.findById(anyLong()))
                .thenReturn(Optional.of(buildPerson()));

        recommendationService.addRecommendation(dto);
        verify(recommendationRepository, times(1))
                .save(recommendation);
        verifyNoMoreInteractions(recommendationRepository);
    }

    @Test
    void shouldDelete_Recommendation_Test() {
        doNothing().when(recommendationRepository)
                .deleteById(anyLong());

        recommendationService.deleteRecommendation(anyLong());
        verify(recommendationRepository, times(1))
                .deleteById(anyLong());
        verifyNoMoreInteractions(recommendationRepository);
    }

    @Test
    void shouldGet_RecommendationDTO_ByPersonId_Test() {
        var list = buildListRecommendation();
        when(recommendationRepository.findAllByPersonId(anyLong()))
                .thenReturn(list);
        when(recommendationMapper.toDTO(list.get(0)))
                .thenReturn(buildRecommendationDTO());

        recommendationService.getRecommendationDTOByPersonId(anyLong());
        verify(recommendationRepository, times(1))
                .findAllByPersonId(any());
    }
}