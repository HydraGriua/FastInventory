package com.fastinventory.inventoryservice.repositories;
import com.fastinventory.inventoryservice.entities.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long>{
}
