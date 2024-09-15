package com.commerce.service.impl;

import com.commerce.entity.Product;
import com.commerce.mapper.ProductMapper;
import com.commerce.model.ProductDto;
import com.commerce.repository.ProductRepository;
import com.commerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    // Método para traer todos los productos
    @Override
    public List<ProductDto> findAll(){
        List<Product> products = productRepository.findAll();
        return productMapper.toDtoList(products);
    }
    // Método para Guardar
    @Override
    public ProductDto save(ProductDto productDto){
        Product product = productMapper.toEntity(productDto);
        Product saveProduct = productRepository.save(product);
        return productMapper.toDto(saveProduct);
    }
    // Método para consultar po id
    @Override
    public ProductDto findId(int id){
        Optional<Product> products = productRepository.findById(id);
        return products.map(productMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    // Método para actualizar un producto
    @Override
    public ProductDto update(int id, ProductDto productDto) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        existingProduct.setName(productDto.getName());
        existingProduct.setCost(productDto.getCost());
        existingProduct.setStock(productDto.getStock());

        Product updatedProduct = productRepository.save(existingProduct);
        return productMapper.toDto(updatedProduct);
    }

    // Método para eliminar un producto
    @Override
    public void delete(int id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        productRepository.delete(product);
    }

}
