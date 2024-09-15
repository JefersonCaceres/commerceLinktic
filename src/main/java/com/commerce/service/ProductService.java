package com.commerce.service;

import com.commerce.model.ProductDto;

import java.util.List;

public interface ProductService {

    List<ProductDto> findAll();
    ProductDto save(ProductDto productDto);
    ProductDto findId(int id);
    ProductDto update(int id, ProductDto productDto);
    void delete(int id);
}
