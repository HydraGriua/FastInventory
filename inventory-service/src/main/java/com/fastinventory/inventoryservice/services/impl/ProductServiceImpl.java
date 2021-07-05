package com.fastinventory.inventoryservice.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.fastinventory.inventoryservice.dtos.CreateProductDto;
import com.fastinventory.inventoryservice.dtos.ProductDto;
import com.fastinventory.inventoryservice.entities.Product;
import com.fastinventory.inventoryservice.repositories.ProductRepository;
import com.fastinventory.inventoryservice.services.ProductService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    public static final ModelMapper modelMapper = new ModelMapper();

    @Override
    public ProductDto getProductById(Long id) {
        return convertToResource(productRepository.findById(id)
        .orElseThrow(()->new RuntimeException("Could not find product")));
    }

    @Override
    public List<ProductDto> getProducts() {
        return convertToResources(productRepository.findAll());
    }

    @Override
    public ProductDto createProduct(CreateProductDto product) {
        Product productEntity = new Product();
        productEntity.setName(product.getName());
        productEntity.setMinStock(product.getMinStock());
        productEntity.setStock(product.getStock());
        Long id;
        try{
            id = productRepository.save(productEntity).getId();
        } catch (Exception e){
            throw new RuntimeException("INTERNAL_SERVER_ERROR");
        }
        return getProductById(id);
    }

    @Override
    public ProductDto updateProduct(Long id, CreateProductDto product) {
        Product productEntity = productRepository.findById(id)
        .orElseThrow(()->new RuntimeException("Could not find product"));
        productEntity.setName(product.getName());
        productEntity.setMinStock(product.getMinStock());
        productEntity.setStock(product.getStock());
        try{
            productRepository.save(productEntity);
        } catch (Exception e){
            throw new RuntimeException("INTERNAL_SERVER_ERROR");
        }
        return getProductById(id);
    }

    @Override
    public String deleteProduct(Long productId) {
        if (!productRepository.existsById(productId)) {
            throw new RuntimeException("Could not find product");
        }
        productRepository.deleteById(productId);
        return "Payment deleted";
    }

    private List<ProductDto> convertToResources(List<Product> products) {
        return products.stream().map(x -> modelMapper.map(x, ProductDto.class)).collect(Collectors.toList());
    }
    private ProductDto convertToResource(Product product) {
        return modelMapper.map(product, ProductDto.class);
    }
}
