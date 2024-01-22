package com.example.petproject.controller;

import com.example.petproject.dto.ProductDTO;
import com.example.petproject.service.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/product")
@RestController
@RequiredArgsConstructor
@Tag(name = "Продукты", description = "методы для работы с продуктами")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public void addProduct(@RequestBody ProductDTO productDTO){
        productService.addProduct(productDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProductById(id);
    }

    @GetMapping
    public List<ProductDTO> getListProduct(){
        return productService.getAllProduct();
    }

    @GetMapping("/{name}")
    public ProductDTO getProduct(@PathVariable String name){
        return productService.getProduct(name);
    }
}
