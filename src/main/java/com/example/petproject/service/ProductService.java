package com.example.petproject.service;

import com.example.petproject.dao.PersonRepository;
import com.example.petproject.dao.ProductRepository;
import com.example.petproject.dto.ProductDTO;
import com.example.petproject.model.Product;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductService {

    final ProductRepository productRepository;
    final ModelMapper modelMapper;

    public void addProduct(ProductDTO productDTO){
        productRepository.save(convertToProduct(productDTO));
    }

    public void deleteProductById(Long id){
        productRepository.deleteById(id);
    }

    public List<ProductDTO> getAllProduct(){
        return productRepository.findAll()
                .stream().map(this::convertToProductDTO)
                .collect(Collectors.toList());
    }

    public ProductDTO getProduct(String name){
        return convertToProductDTO(productRepository.findByName(name));
    }

    private Product convertToProduct(ProductDTO productDTO){
        return modelMapper.map(productDTO, Product.class);
    }

    private ProductDTO convertToProductDTO(Product product){
        return modelMapper.map(product, ProductDTO.class);
    }
}
