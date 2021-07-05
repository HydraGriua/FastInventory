package com.fastinventory.inventoryservice.services;

import java.util.List;

import com.fastinventory.inventoryservice.dtos.CreateProductDto;
import com.fastinventory.inventoryservice.dtos.ProductDto;

public interface ProductService {
    ProductDto getProductById(Long id);
    List<ProductDto> getProducts();
    ProductDto createProduct(CreateProductDto product);
    ProductDto updateProduct(Long id, CreateProductDto product);
    String deleteProduct(Long productId);
}
