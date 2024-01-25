package com.example.petproject.controller;

import com.example.petproject.dto.ProductDTO;
import com.example.petproject.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/products")
@RestController
@RequiredArgsConstructor
@Tag(name = "Продукты", description = "методы для работы с продуктами")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @Operation(summary = "добавляет продукт")
    public void addProduct(@RequestBody ProductDTO productDTO){
        productService.addProduct(productDTO);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "удаляет продукт по идентификатору")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProductById(id);
    }

    @GetMapping
    @Operation(summary = "возвращает список продуктов")
    public List<ProductDTO> getListProduct(){
        return productService.getAllProduct();
    }

    @GetMapping("/{name}")
    @Operation(summary = "возвращает продукт по названию")
    public ProductDTO getProduct(@PathVariable String name){
        return productService.getProduct(name);
    }
}
