package com.ecart.product.controller;

import com.ecart.product.dto.AddReviewRequest;
import com.ecart.product.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reviews")
public class ProductReviewController {

    @Autowired
    private ProductService productService;

    
    
    @PostMapping
    public ResponseEntity<String> addReview(@RequestBody @Valid AddReviewRequest request) {
        String message = productService.addReview(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(message);
    }
}
