package com.ecart.product.dto;

import jakarta.validation.constraints.*;


public class AddReviewRequest {

    @NotNull(message = "Product ID is required")
    private Long productId;

    @NotNull(message = "Rating is required")
    @Min(value = 1, message = "Rating must be at least 1")
    @Max(value = 5, message = "Rating must be at most 5")
    private Double rating;

    @NotBlank(message = "Comment is required")
    private String comment;

    

    public Long getProductId() {
    	return productId; 
    	}
    public void setProductId(Long productId) { 
    	this.productId = productId; 
    	
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
}
