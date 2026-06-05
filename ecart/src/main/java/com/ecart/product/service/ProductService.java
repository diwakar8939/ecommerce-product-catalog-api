package com.ecart.product.service;

import com.ecart.product.dto.AddReviewRequest;
import com.ecart.product.entity.Product;
import com.ecart.product.entity.ProductReview;
import com.ecart.product.repository.ProductRepository;
import com.ecart.product.repository.ProductReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductReviewRepository productReviewRepository;
    
    
    
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    
    public Product getProductById(Long id) {
        
    	return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }
    

 
     
    public Product updateProduct(Long id, Product updatedData) {
        
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
 

        if (updatedData.getName() != null) {
            existingProduct.setName(updatedData.getName());
        }
        if (updatedData.getPrice() != null) {
            existingProduct.setPrice(updatedData.getPrice());
        }
        if (updatedData.getDescription() != null) {
            existingProduct.setDescription(updatedData.getDescription());
        }
        if (updatedData.getCategory() != null) {
            existingProduct.setCategory(updatedData.getCategory());
        }
        if (updatedData.getSeller() != null) {
            existingProduct.setSeller(updatedData.getSeller());
        }
        if (updatedData.getStock() != null) {
            existingProduct.setStock(updatedData.getStock());
        }
 
        
        return productRepository.save(existingProduct);
    }
 
    
 
    public String deleteProduct(Long id) {
        
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
 
        productRepository.delete(product);
        return "Product deleted successfully!";
    }
    

    


    public List<Product> searchProducts(String category, String keyword,
                                        Double minPrice, Double maxPrice,
                                        Double minRating) {

        List<Product> results;

        
        if (keyword != null && !keyword.isEmpty()) { 
            results = productRepository
                    .findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(keyword, keyword);

        }  else {
            results = productRepository.findAll();
        }
        
         if (category != null && !category.isEmpty()) {   
            results = productRepository.findByCategory(category);

        }

        
        if (minPrice != null) {
            results = results.stream()
                    .filter(p -> p.getPrice() >= minPrice)
                    .toList();
        }
        if (maxPrice != null) {
            results = results.stream()
                    .filter(p -> p.getPrice() <= maxPrice)
                    .toList();
        }

        
        if (minRating != null) {
            results = results.stream()
                    .filter(p -> p.getRatings() >= minRating)
                    .toList();
        }

        return results;
    }
    
    

    

    public String addReview(AddReviewRequest request) {
        
        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + request.getProductId()));

        
        ProductReview review = new ProductReview();
        review.setRating(request.getRating());
        review.setComment(request.getComment());
        review.setProduct(product);
        productReviewRepository.save(review);

        
        updateProductRating(product);

        return "Review added successfully!";
    }

    

    private void updateProductRating(Product product) {
        List<ProductReview> allReviews = product.getReviews();

        if (allReviews.isEmpty()) {
            product.setRatings(0.0);
            product.setNumOfReviews(0);
        } else {
            
            double total = 0;
            for (ProductReview r : allReviews) {
                total += r.getRating();
            }
            double average = total / allReviews.size();

            
            double rounded = Math.round(average * 10.0) / 10.0;

            product.setRatings(rounded);
            product.setNumOfReviews(allReviews.size());
        }

        productRepository.save(product);
    }
}
