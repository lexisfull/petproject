package com.example.petproject.controller;

import com.example.petproject.controller.api.ProductAPI;
import com.example.petproject.dto.ProductDTO;
import com.example.petproject.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static com.example.petproject.factory.TestObjectFactory.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductAPI.class)
class ProductControllerTest {

    @MockBean
    private ProductService productService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void addProductTest_shouldStatusIsCreated() throws Exception {
        ProductDTO productDTO = buildProductDTO();

        mockMvc.perform(post("/products")
                .content(objectMapper.writeValueAsString(productDTO))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    void deleteProductTest_shouldStatusIsOk() throws Exception {
        mockMvc.perform(delete("/products/1"))
                .andExpect(status().isOk());
    }

    @Test
    void getListProductTest_shouldPersonDTOList_andStatusIsOk() throws Exception {
        List<ProductDTO> productDTOList = buildListProductDTO();
        when(productService.getAllProduct()).thenReturn(productDTOList);

        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value("1"))
                .andExpect(jsonPath("$[0].fat").value("7.2"))
                .andExpect(jsonPath("$[0].name").value("рис"))
                .andExpect(jsonPath("$[1].id").value("2"))
                .andExpect(jsonPath("$[1].fat").value("1.0"))
                .andExpect(jsonPath("$[1].name").value("греча"));
    }

    @Test
    void getProductTest_shouldPersonDTO_andStatusIsOk() throws Exception {
        ProductDTO productDTO = buildProductDTO();
        when(productService.getProduct(1L)).thenReturn(productDTO);

        mockMvc.perform(get("/products/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.fat").value("7.2"))
                .andExpect(jsonPath("$.name").value("рис"));

    }
}