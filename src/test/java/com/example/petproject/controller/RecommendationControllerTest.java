package com.example.petproject.controller;

import com.example.petproject.dto.RecommendationDTO;
import com.example.petproject.service.RecommendationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static com.example.petproject.factory.TestObjectFactory.buildListRecommendationDTO;
import static com.example.petproject.factory.TestObjectFactory.buildRecommendationDTO;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RecommendationController.class)
class RecommendationControllerTest {

    @MockBean
    private RecommendationService recommendationService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void addRecommendationTest_shouldStatusIsCreated_andRecommendation() throws Exception {
        RecommendationDTO recommendationDTO = buildRecommendationDTO();

        mockMvc.perform(post("/recommendation")
                .content(objectMapper.writeValueAsString(recommendationDTO))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

    }

    @Test
    void deleteRecommendationTest_shouldStatusIsOk() throws Exception {
        mockMvc.perform(delete("/recommendation/1"))
                .andExpect(status().isOk());
    }

    @Test
    void getRecommendationPersonTest_shouldRecommendationDTOList_andStatusIsOk() throws Exception {
        List<RecommendationDTO> recommendationDTOList = buildListRecommendationDTO();
        when(recommendationService.getRecommendationDTOByPersonId(1L))
                .thenReturn(recommendationDTOList);

        mockMvc.perform(get("/recommendation/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value("1"))
                .andExpect(jsonPath("$[0].recommendation").value("commit"));
    }
}