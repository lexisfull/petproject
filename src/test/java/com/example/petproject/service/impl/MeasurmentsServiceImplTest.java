package com.example.petproject.service.impl;

import com.example.petproject.dao.MeasurmentsRepository;
import com.example.petproject.dao.PersonRepository;
import com.example.petproject.factory.TestObjectFactory;
import com.example.petproject.mapper.MeasurmentsListMapper;
import com.example.petproject.mapper.MeasurmentsMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.example.petproject.factory.TestObjectFactory.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MeasurmentsServiceImplTest {

    @Mock
    private MeasurmentsRepository measurmentsRepository;

    @Mock
    private MeasurmentsMapper measurmentsMapper;

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private MeasurmentsServiceImpl measurmentsService;

    @Test
    void shouldAdd_Measurments_Test() {
        var measurments = buildMeasurments();
        when(measurmentsMapper.toMeasurments(buildMeasurmentsDTO()))
                .thenReturn(measurments);
        when(personRepository.findById(any()))
                .thenReturn(Optional.of(buildPerson()));

        measurmentsService.addMeasurments(buildMeasurmentsDTO());

        verify(measurmentsRepository, times(1))
                .save(measurments);
        verifyNoMoreInteractions(measurmentsRepository);
    }

    @Test
    void shouldDelete_Measurments_Test() {
        doNothing().when(measurmentsRepository).deleteById(anyLong());

        measurmentsService.deleteMeasurments(anyLong());

        verify(measurmentsRepository, times(1)).deleteById(anyLong());
        verifyNoMoreInteractions(measurmentsRepository);

    }

    @Test
    void shouldGet_Measurments_PersonId_Test() {
        var list = buildListMeasurments();
        when(measurmentsRepository.findAllByPersonId(anyLong()))
                .thenReturn(list);
        when(measurmentsMapper.toDTO(list.get(0)))
                .thenReturn(buildMeasurmentsDTO());

        measurmentsService.getMeasurmentsPersonId(anyLong());

        verify(measurmentsRepository, times(1)).findAllByPersonId(anyLong());
        verifyNoMoreInteractions(measurmentsRepository);
    }
}