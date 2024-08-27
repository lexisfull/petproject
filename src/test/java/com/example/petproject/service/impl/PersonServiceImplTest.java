package com.example.petproject.service.impl;

import com.example.petproject.container.TestContainer;
import com.example.petproject.dao.PersonRepository;
import com.example.petproject.mapper.PersonMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.Optional;

import static com.example.petproject.factory.TestObjectFactory.buildListPerson;
import static com.example.petproject.factory.TestObjectFactory.buildPerson;
import static com.example.petproject.factory.TestObjectFactory.buildPersonDTO;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@Testcontainers
class PersonServiceImplTest extends TestContainer {

    @Mock
    private PersonRepository personRepository;

    @Mock
    private PersonMapper personMapper;

    @InjectMocks
    private PersonServiceImpl personService;

    @Test
    void shouldGet_Persons_Test() {
        var list = buildListPerson();
        var dto = buildPersonDTO();
        when(personRepository.findAll())
                .thenReturn(list);
        when(personMapper.toDTONotAnalysis(any()))
                .thenReturn(dto);

        personService.getPersons();

        verify(personRepository).findAll();
        verify(personRepository, times(1)).findAll();
        verifyNoMoreInteractions(personRepository);
    }

    @Test
    void shouldGet_PersonById_Test() {
        var person = buildPerson();
        var dto = buildPersonDTO();
        when(personRepository.findById(anyLong()))
                .thenReturn(Optional.of(person));
        when(personMapper.toDTO(person))
                .thenReturn(dto);

        personService.getPersonById(anyLong());

        verify(personRepository).findById(anyLong());
        verify(personRepository, times(1))
                .findById(anyLong());
        verifyNoMoreInteractions(personRepository);
    }

    @Test
    void shouldGet_PersonByName_Test() {
        var person = buildPerson();
        var dto = buildPersonDTO();
        when(personRepository.findByName(any()))
                .thenReturn(person);
        when(personMapper.toDTO(person))
                .thenReturn(dto);

        personService.getPersonByName(any());

        verify(personRepository).findByName(any());
        verify(personRepository, times(1))
                .findByName(any());
        verifyNoMoreInteractions(personRepository);
    }

    @Test
    void shouldCreate_Person_Test() {
        var dto = buildPersonDTO();
        when(personMapper.toPersonNotList(dto))
                .thenReturn(buildListPerson().get(0));

        personService.createPerson(dto);

        verify(personRepository, times(1))
                .save(any());
        verifyNoMoreInteractions(personRepository);
    }

    @Test
    void shouldDelete_ByPerson_Test() {
        doNothing().when(personRepository).deleteById(anyLong());

        personService.deleteByPerson(anyLong());
        verify(personRepository, times(1))
                .deleteById(anyLong());
        verifyNoMoreInteractions(personRepository);
    }
}