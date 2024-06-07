package com.example.petproject.controller.api;

import com.example.petproject.dto.ProductDTO;
import com.example.petproject.model.Product;
import com.example.petproject.service.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/products")
@RestController
@RequiredArgsConstructor
@Tag(name = "Продукты", description = "методы для работы с продуктами")
public class ProductController implements com.example.petproject.controller.ProductAPI {

    private final ProductService productService;

    @Override
    public ResponseEntity<Product> addProduct(@RequestBody ProductDTO productDTO){
        return new ResponseEntity<>(productService.addProduct(productDTO), HttpStatus.CREATED);
    }

    @Override
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProductById(id);
    }

    @Override
    public ResponseEntity<List<ProductDTO>> getListProduct(){
        return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.OK);
    }

    @Override
    public ProductDTO getProduct(@PathVariable Long id){
        return productService.getProduct(id);
    }
}
