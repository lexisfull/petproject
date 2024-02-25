package com.example.petproject.service.impl;

import com.example.petproject.dao.ExecutorRepository;
import com.example.petproject.dto.ExecutorDTO;
import com.example.petproject.mapper.ExecutorMapper;
import com.example.petproject.service.impl.ExecutorServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.example.petproject.factory.TestObjectFactory.buildExecutor;
import static com.example.petproject.factory.TestObjectFactory.buildExecutorDTO;
import static com.example.petproject.factory.TestObjectFactory.buildListExecutor;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExecutorServiceImplTest {

    @Mock
    private ExecutorMapper executorMapper;

    @Mock
    private ExecutorRepository executorRepository;

    @InjectMocks
    private ExecutorServiceImpl executorService;


    @Test
    void shouldGet_AllExecutor_Test() {
        var list = buildListExecutor();
        var dto = buildExecutorDTO();
        when(executorRepository.findAll())
                .thenReturn(list);
        when(executorMapper.toDTO(any()))
                .thenReturn(dto);

        executorService.getAllExecutor();

        verify(executorRepository).findAll();
        verifyNoMoreInteractions(executorRepository);
    }

    @Test
    void shouldGet_ExecutorById_Test() {
        var executor = buildExecutor();
        var dto = buildExecutorDTO();
        when(executorRepository.findById(anyLong()))
                .thenReturn(Optional.of(executor));

        executorService.getExecutorById(anyLong());

        verify(executorRepository, times(1))
                .findById(anyLong());
        verifyNoMoreInteractions(executorRepository);
    }

    @Test
    void shouldAdd_Executor_Test() {
        ExecutorDTO executorDTO = buildExecutorDTO();
        when(executorMapper.toExecutor(executorDTO))
                .thenReturn(buildListExecutor().get(0));

        executorService.addExecutor(executorDTO);

        verify(executorRepository, times(1)).save(any());
        verifyNoMoreInteractions(executorRepository);

    }

    @Test
    void shouldDelete_Executor_Test() {
        doNothing().when(executorRepository).deleteById(anyLong());

        executorService.deleteExecutor(anyLong());
        verify(executorRepository, times(1))
                .deleteById(anyLong());
        verifyNoMoreInteractions(executorRepository);
    }
}