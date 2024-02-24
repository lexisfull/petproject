package com.example.petproject.service;

import com.example.petproject.dto.ProductDTO;
import com.example.petproject.model.Product;

import java.util.List;

public interface ProductService {

    Product addProduct(ProductDTO productDTO);

    void deleteProductById(Long id);

    List<ProductDTO> getAllProduct();

    ProductDTO getProduct(Long id);
}
