package com.ecart.product.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "product_reviews")
public class ProductReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Rating is required")
    @Min(value = 1, message = "Rating must be at least 1")
    @Max(value = 5, message = "Rating must be at most 5")
    private Double rating;

    @NotBlank(message = "Comment is required")
    private String comment;


    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private Product product;

    

    public ProductReview() {
    	
    }



    public Long getId() { 
    	
    	return id; 
    	}
    
    public void setId(Long id) { 
    	
    	this.id = id;
    	}

    public Double getRating() { 
    	return rating; 
    	
    }
    public void setRating(Double rating) { 
    	this.rating = rating; 
    	
    }

    public String getComment() {
    	return comment;
    	
    }
    public void setComment(String comment) { 
    	this.comment = comment; 
    	
    }

    public Product getProduct() { 
    	
    	return product; 
    	
    }
    public void setProduct(Product product) {
    	this.product = product; 
    	
    }
}
