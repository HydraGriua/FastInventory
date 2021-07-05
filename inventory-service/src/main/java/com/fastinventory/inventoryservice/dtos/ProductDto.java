package com.fastinventory.inventoryservice.dtos;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    private Long id;
    private Date createdDate;
    private String name;
    private int stock;
    private int minStock;
}
