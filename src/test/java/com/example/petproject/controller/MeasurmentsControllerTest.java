package com.example.petproject.controller;

import com.example.petproject.dto.MeasurmentsDTO;
import com.example.petproject.service.MeasurmentsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static com.example.petproject.factory.TestObjectFactory.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MeasurmentsController.class)
class MeasurmentsControllerTest {

    @MockBean
    private MeasurmentsService measurmentsService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;


    @Test
    void addMeasurmentsTest_shouldStatusIsOk() throws Exception {
        MeasurmentsDTO measurmentsDTO = buildMeasurmentsDTO();

        mockMvc.perform(post("/measurments")
                .content(objectMapper.writeValueAsString(measurmentsDTO))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());


    }

    @Test
    void deleteMeasurmentsTest_shouldStatusIsOk() throws Exception {
        mockMvc.perform(delete("/measurments/1"))
                .andExpect(status().isOk());
    }

    @Test
    void getMeasurmentsPersonTest_shouldListMeasurments_andStatusIsOk() throws Exception {
        List<MeasurmentsDTO> measurmentsDTOList = buildListMeasurmentsDTO();
        when(measurmentsService.getMeasurmentsPersonId(1L))
                .thenReturn(measurmentsDTOList);

        mockMvc.perform(get("/measurments/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[1].id").value("2"))
                .andExpect(jsonPath("$[1].height").value("170"));
    }
}