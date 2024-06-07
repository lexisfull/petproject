package com.example.petproject.controller;

import com.example.petproject.dto.ProductDTO;
import com.example.petproject.model.Product;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/products")
public interface ProductAPI {

    @PostMapping
    @Operation(summary = "добавляет продукт")
    ResponseEntity<Product> addProduct(@RequestBody ProductDTO productDTO);

    @DeleteMapping("/{id}")
    @Operation(summary = "удаляет продукт по идентификатору")
    public void deleteProduct(@PathVariable Long id);

    @GetMapping
    @Operation(summary = "возвращает список продуктов")
    public ResponseEntity<List<ProductDTO>> getListProduct();

    @GetMapping("/{id}")
    @Operation(summary = "возвращает продукт по названию")
    public ProductDTO getProduct(@PathVariable Long id);
}
