package com.fastinventory.inventoryservice.controllers;

import java.util.List;

import javax.validation.Valid;

import com.fastinventory.inventoryservice.dtos.CreateProductDto;
import com.fastinventory.inventoryservice.dtos.ProductDto;
import com.fastinventory.inventoryservice.responses.ResourceResponse;
import com.fastinventory.inventoryservice.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public ResourceResponse<List<ProductDto>> getProducts() throws RuntimeException{
        return new ResourceResponse<>("Success",String.valueOf(HttpStatus.OK),"OK",
                productService.getProducts());
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public ResourceResponse<ProductDto> getProductById(@PathVariable("id") Long id) throws RuntimeException{
        return new ResourceResponse<>("Success",String.valueOf(HttpStatus.OK),"OK",
                productService.getProductById(id));
    }
    @ResponseStatus(HttpStatus.OK)
    @PostMapping()
    public ResourceResponse<ProductDto> createProduct(@RequestBody @Valid CreateProductDto createProductDto) throws RuntimeException{
        return new ResourceResponse<>("Success",String.valueOf(HttpStatus.OK),"OK",
                productService.createProduct(createProductDto));
    }
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public ResourceResponse<ProductDto> updateProduct(@RequestBody @Valid CreateProductDto updateProductDto,@PathVariable("id") Long id) throws RuntimeException{
        return new ResourceResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
                productService.updateProduct(id,updateProductDto));
    }
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public ResourceResponse<String> deleteProduct(@PathVariable("id") Long id) throws RuntimeException{
        return new ResourceResponse<>("Success",String.valueOf(HttpStatus.OK),"OK",
                productService.deleteProduct(id));
    }
}
