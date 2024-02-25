package com.example.petproject.service.impl;

import com.example.petproject.dao.ProductRepository;
import com.example.petproject.factory.TestObjectFactory;
import com.example.petproject.mapper.ProductMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.example.petproject.factory.TestObjectFactory.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    private ProductMapper productMapper;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    void shouldAdd_Product_Test() {
        var dto = buildProductDTO();
        var product = buildProduct();
        when(productMapper.toProduct(dto))
                .thenReturn(product);
        lenient().when(productRepository.findById(anyLong()))
                .thenReturn(any());

        productService.addProduct(dto);

        verify(productRepository, times(1))
                .save(any());
        verifyNoMoreInteractions(productRepository);

    }

    @Test
    void shouldDelete_ProductById_Test() {
        doNothing().when(productRepository)
                .deleteById(anyLong());

        productService.deleteProductById(anyLong());

        verify(productRepository, times(1))
                .deleteById(anyLong());
        verifyNoMoreInteractions(productRepository);
    }

    @Test
    void shouldGet_AllProduct_Test() {
        var dto = buildProductDTO();
        var list = buildListProduct();
        when(productRepository.findAll())
                .thenReturn(list);
        when(productMapper.toDTO(any()))
                .thenReturn(dto);

        productService.getAllProduct();

        verify(productRepository, times(1))
                .findAll();
        verifyNoMoreInteractions(productRepository);
    }

    @Test
    void shouldGet_Product_Test() {
        var product = buildProduct();
        var dto = buildProductDTO();
        when(productRepository.findAllById(anyLong()))
                .thenReturn(buildListProduct().get(0));
        when(productMapper.toDTO(any()))
                .thenReturn(dto);

        productService.getProduct(anyLong());

        verify(productRepository, times(1))
                .findAllById(anyLong());
    }
}