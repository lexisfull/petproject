package com.example.petproject.service.impl;

import com.example.petproject.dao.ProductRepository;
import com.example.petproject.dto.ProductDTO;
import com.example.petproject.mapper.ProductMapper;
import com.example.petproject.model.Product;
import com.example.petproject.service.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductServiceImpl implements ProductService {

    final ProductRepository productRepository;

    final ProductMapper productMapper;

    @Override
    public Product addProduct(ProductDTO productDTO){
        return productRepository.save(productMapper.toProduct(productDTO));
    }

    @Override
    public void deleteProductById(Long id){
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductDTO> getAllProduct(){
        return productRepository.findAll()
                .stream().map(productMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO getProduct(Long id){
        return productMapper.toDTO(productRepository.findAllById(id));
    }


}
