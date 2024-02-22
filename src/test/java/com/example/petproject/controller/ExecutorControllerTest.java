package com.example.petproject.controller;

import com.example.petproject.dto.ExecutorDTO;
import com.example.petproject.service.ExecutorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static com.example.petproject.factory.TestObjectFactory.buildExecutor;
import static com.example.petproject.factory.TestObjectFactory.buildListExecutor;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(ExecutorController.class)
class ExecutorControllerTest {

    @MockBean
    private ExecutorService executorService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void addExecutorTests_shouldStatusIsOk() throws Exception {
        ExecutorDTO executorDTO = buildExecutor();

        mockMvc.perform(post("/executor")
                        .content(objectMapper.writeValueAsString(executorDTO))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    void deleteExecutorTest_shouldStatusIsOk() throws Exception {
        mockMvc.perform(delete("/executor/1"))
                .andExpect(status().isOk());
    }

    @Test
    void getAllExecutorTest_shouldListExecutor_andStatusIsOk() throws Exception {
        List<ExecutorDTO> executorDTOList = buildListExecutor();
        when(executorService.getAllExecutor())
                .thenReturn(executorDTOList);

        mockMvc.perform(get("/executor"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id").value("1"))
                .andExpect(jsonPath("$[0].name").value("Masha"));

    }

    @Test
    void getExecutorIdTest_shouldExecutor_andStatusIsOk() throws Exception {
        ExecutorDTO executorDTO = buildExecutor();
        when(executorService.getExecutorById(1L))
                .thenReturn(executorDTO);

        mockMvc.perform(get("/executor/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.age").value("35"))
                .andExpect(jsonPath("$.name").value("Masha"));
    }
}