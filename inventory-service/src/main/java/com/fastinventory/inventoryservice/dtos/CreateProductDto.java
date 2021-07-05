package com.fastinventory.inventoryservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductDto {
    private String name;
    private int stock;
    private int minStock;
}
