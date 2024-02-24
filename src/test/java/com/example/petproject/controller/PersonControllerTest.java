package com.example.petproject.controller;

import com.example.petproject.controller.api.PersonAPI;
import com.example.petproject.dto.PersonDTO;
import com.example.petproject.service.PersonService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static com.example.petproject.factory.TestObjectFactory.buildListPersonDTO;
import static com.example.petproject.factory.TestObjectFactory.buildPersonDTO;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PersonAPI.class)
class PersonControllerTest {

    @MockBean
    private PersonService personService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getPearsonTest_shouldPersonDTOList_andStatusIsOk() throws Exception {
        List<PersonDTO> personDTOList = buildListPersonDTO();
        when(personService.getPersons()).thenReturn(personDTOList);

        mockMvc.perform(get("/persons"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value("1"))
                .andExpect(jsonPath("$[0].name").value("Vova"))
                .andExpect(jsonPath("$[0].age").value("35"))
                .andExpect(jsonPath("$[1].id").value("2"))
                .andExpect(jsonPath("$[1].name").value("Sasha"))
                .andExpect(jsonPath("$[1].age").value("35"));
    }

    @Test
    void getPersonByIdTest_shouldPersonDTO() throws Exception {
        PersonDTO personDTO = buildPersonDTO();
        when(personService.getPersonById(1L)).thenReturn(personDTO);

        mockMvc.perform(get("/persons/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.name").value("Vova"))
                .andExpect(jsonPath("$.age").value("35"));
    }

    @Test
    void getPersonByNameTest_shouldPersonDTOByName() throws Exception {
        PersonDTO personDTO = buildPersonDTO();
        when(personService.getPersonByName("Vova")).thenReturn(personDTO);

        mockMvc.perform(get("/persons/person/Vova"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.name").value("Vova"))
                .andExpect(jsonPath("$.age").value("35"));
    }

    @Test
    void addPersonTest_shouldStatusIsCreated() throws Exception {
        PersonDTO personDTO = buildPersonDTO();

        mockMvc.perform(post("/persons")
                        .content(objectMapper.writeValueAsString(personDTO))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    void deletePersonTest_shouldStatusIsOk() throws Exception {

        mockMvc.perform(delete("/persons/1"))
                .andExpect(status().isOk());
    }
}
