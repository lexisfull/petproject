package com.example.petproject.controller;

import com.example.petproject.dto.AnalysisDTO;
import com.example.petproject.factory.TestObjectFactory;
import com.example.petproject.model.Analysis;
import com.example.petproject.model.Person;
import com.example.petproject.service.AnalysisService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static com.example.petproject.factory.TestObjectFactory.buildAnalysis;
import static com.example.petproject.factory.TestObjectFactory.buildListAnalysis;
import static com.example.petproject.factory.TestObjectFactory.buildAnalysisDTO;
import static com.example.petproject.factory.TestObjectFactory.buildPerson;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AnalysisController.class)
//@ExtendWith(MockitoExtension.class)
class AnalysisControllerTest {

    @MockBean
    private AnalysisService analysisService;


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
        Analysis analysis = buildAnalysis();
        Person personId = buildPerson();
        when(analysisService.getAllAnalysisPerson(analysis.getPersonId()))
                .thenReturn(List.of(analysisDTO));

        mockMvc.perform(get("/analysis/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value("1"))
                .andExpect(jsonPath("$[0].resultAnalyses").value("analysis"));;
    }

    @Test
    void addAnalysisTest() {
    }

    @Test
    void deleteAnalysis() {
//        Analysis analysis = buildAnalysis();
//        Mockito.when().thenReturn(null);
    }
}