package com.example.petproject.mapper;

import com.example.petproject.dto.ProductDTO;
import com.example.petproject.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
     ProductDTO toDTO(Product product);

     Product toProduct(ProductDTO productDTO);
}
