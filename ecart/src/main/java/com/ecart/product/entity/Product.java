package com.ecart.product.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotNull(message = "Price is required")
    @PositiveOrZero(message = "Price must be 0 or greater")
    private Double price;

    @NotBlank(message = "Description is required")
    private String description;

    private String category;

    private String seller;

    @NotNull(message = "Stock is required")
    private Integer stock;

    
    private Double ratings = 0.0;

    
    private Integer numOfReviews = 0;

   
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductReview> reviews = new ArrayList<>();

    

    public Product() {
    	
    	
    }

   

    public Long getId() { 
    	
    	return id;
    	}
    public void setId(Long id) { 
    	this.id = id; 
    	}

    public String getName() { 
    	return name;
    	}
    public void setName(String name) { 
    	this.name = name;
    	}

    public Double getPrice() { 
    	return price; 
    	}
    public void setPrice(Double price) { 
    	this.price = price; 
    	}

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getSeller() { return seller; }
    public void setSeller(String seller) { this.seller = seller; }

    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }

    public Double getRatings() { return ratings; }
    public void setRatings(Double ratings) { this.ratings = ratings; }

    public Integer getNumOfReviews() { return numOfReviews; }
    public void setNumOfReviews(Integer numOfReviews) { this.numOfReviews = numOfReviews; }

    public List<ProductReview> getReviews() { return reviews; }
    public void setReviews(List<ProductReview> reviews) { this.reviews = reviews; }
}
