package com.commerce.mapper;

import com.commerce.entity.Product;
import com.commerce.model.ProductDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {
    public ProductDto toDto(Product product) {
        ProductDto dto = new ProductDto();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setCost(product.getCost());
        dto.setStock(product.getStock());
        return dto;
    }

    public Product toEntity(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setCost(productDto.getCost());
        product.setStock(productDto.getStock());
        return product;
    }

    public List<ProductDto> toDtoList(List<Product> productList) {
        return productList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public List<Product> toEntityList(List<ProductDto> productDtoList) {
        return productDtoList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}
