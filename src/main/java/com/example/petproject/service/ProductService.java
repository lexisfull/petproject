package com.example.petproject.service;

import com.example.petproject.dao.ProductRepository;
import com.example.petproject.dto.ProductDTO;
import com.example.petproject.mapper.ProductMapper;
import com.example.petproject.model.Product;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductService {

    final ProductRepository productRepository;

    final ProductMapper productMapper;

    public Product addProduct(ProductDTO productDTO){
        return productRepository.save(productMapper.toProduct(productDTO));
    }

    public void deleteProductById(Long id){
        productRepository.deleteById(id);
    }

    public List<ProductDTO> getAllProduct(){
        return productRepository.findAll()
                .stream().map(productMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ProductDTO getProduct(Long id){
        return productMapper.toDTO(productRepository.findAllById(id));
    }


}
