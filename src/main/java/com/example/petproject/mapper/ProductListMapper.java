package com.example.petproject.mapper;

import com.example.petproject.dto.ProductDTO;
import com.example.petproject.model.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface ProductListMapper {
    List<ProductDTO> toDTO(List<Product> productList);
    List<Product> toProduct(List<ProductDTO> productDTOList);
}
