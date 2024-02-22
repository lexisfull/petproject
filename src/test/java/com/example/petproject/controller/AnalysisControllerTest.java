package com.example.petproject.controller;

import com.example.petproject.dto.AnalysisDTO;
import com.example.petproject.service.AnalysisService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;


import static com.example.petproject.factory.TestObjectFactory.buildAnalysisDTO;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AnalysisController.class)
//@ExtendWith(MockitoExtension.class)
class AnalysisControllerTest {

    @MockBean
    private AnalysisService analysisService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAllAnalysisTest() throws Exception {
        AnalysisDTO analysisDTO = buildAnalysisDTO();
        when(analysisService.getAllAnalysis()).thenReturn(List.of(analysisDTO));

        mockMvc.perform(get("/analysis"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].resultAnalyses").value("analysis"));
    }

    @Test
    void getAnalysisPersonTest() throws Exception {
        AnalysisDTO analysisDTO = buildAnalysisDTO();
        when(analysisService.getAllAnalysisPerson(1L))
                .thenReturn(List.of(analysisDTO));

        mockMvc.perform(get("/analysis/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value("1"))
                .andExpect(jsonPath("$[0].resultAnalyses").value("analysis"));;
    }

    @Test
    void addAnalysisTest() throws Exception {
        AnalysisDTO analysisDTO = buildAnalysisDTO();

        mockMvc.perform(post("/analysis")
                        .content(objectMapper.writeValueAsString(analysisDTO))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void deleteAnalysisTest() throws Exception {
        mockMvc.perform(delete("/analysis/1"))
                .andExpect(status().isOk());
    }
}