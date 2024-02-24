package com.example.petproject.service;

import com.example.petproject.dao.EatingRepository;
import com.example.petproject.dao.PersonRepository;
import com.example.petproject.dto.EatingDTO;
import com.example.petproject.mapper.EatingListMapper;
import com.example.petproject.mapper.EatingMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static com.example.petproject.factory.TestObjectFactory.buildEatingDTO;
import static com.example.petproject.factory.TestObjectFactory.buildListEating;
import static com.example.petproject.factory.TestObjectFactory.buildPerson;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EatingServiceTest {

    @MockBean
    private EatingRepository eatingRepository;

    @MockBean
    private PersonRepository personRepository;

    @MockBean
    private EatingMapper eatingMapper;

    @MockBean
    private EatingListMapper eatingListMapper;

    @InjectMocks
    private EatingService eatingService;

    @Test
    void shouldGetEating_PersonId() {
        var list = buildListEating();
        var dto = buildEatingDTO();
        when(eatingRepository.findAllByPersonId(1L))
                .thenReturn(list);
        when(eatingMapper.toDTO(any()))
                .thenReturn(dto);

        eatingService.getEatingPerson(1L);

        verify(eatingRepository).findAllByPersonId(1L);
    }

    @Test
    void shouldAdd_EatingTest() {
        EatingDTO eatingDTO = buildEatingDTO();
        when(eatingMapper.toEating(eatingDTO))
                .thenReturn(buildListEating().get(0));
        when(personRepository.findById(any()))
                .thenReturn(Optional.of(buildPerson()));

        eatingService.addEating(eatingDTO);

        verify(eatingRepository, times(1)).save(any());

    }

    @Test
    void deleteEating() {
        doNothing().when(eatingRepository).deleteById(anyLong());

        eatingService.deleteEating(anyLong());
        verify(eatingRepository, times(1))
                .deleteById(anyLong());
        verifyNoMoreInteractions(eatingRepository);
    }
}