package com.ecart.product.repository;

import com.ecart.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    

    
    List<Product> findByCategory(String category);

    
    List<Product> findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String name, String description);

    
    List<Product> findByPriceBetween(Double minPrice, Double maxPrice);

    
    List<Product> findByRatingsGreaterThanEqual(Double ratings);
}
