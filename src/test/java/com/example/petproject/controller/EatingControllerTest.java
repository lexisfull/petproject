package com.example.petproject.controller;

import com.example.petproject.dto.EatingDTO;
import com.example.petproject.service.EatingService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import java.util.List;

import static com.example.petproject.factory.TestObjectFactory.buildEatingDTO;
import static com.example.petproject.factory.TestObjectFactory.buildListEatingDTO;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EatingController.class)
class EatingControllerTest {

    @MockBean
    private EatingService eatingService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void addEatingTest() throws Exception {
        EatingDTO eatingDTO = buildEatingDTO();

        mockMvc.perform(post("/eating")
                .content(objectMapper.writeValueAsString(eatingDTO))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void deleteEatingTest() throws Exception {
        mockMvc.perform(delete("/eating/1"))
                .andExpect(status().isOk());
    }

    @Test
    void getEatingPersonIdTest() throws Exception {
        List<EatingDTO> eatingDTOList = buildListEatingDTO();
        when(eatingService.getEatingPerson(1L))
                .thenReturn(eatingDTOList);

        mockMvc.perform(get("/eating/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id").value("1"))
                .andExpect(jsonPath("$[0].personId").value("1"))
                .andExpect(jsonPath("$[1].id").value("2"))
                .andExpect(jsonPath("$[1].personId").value("1"));

    }
}