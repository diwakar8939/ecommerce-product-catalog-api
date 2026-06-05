package com.ecart.product.seeder;

import com.ecart.product.entity.Product;
import com.ecart.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class DataSeeder implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) {

        
        if (productRepository.count() > 0) {
            System.out.println("Products already exist. Skipping seed.");
            return;
        }

        List<Product> products = List.of(
                createProduct("Samsung Galaxy Z Fold 8", 149999.00,
                        "Premium foldable smartphone with large display",
                        "Smartphones", "Samsung", 50),

                createProduct("OnePlus Buds Pro 4", 12999.00,
                        "Wireless earbuds with active noise cancellation",
                        "Earbuds", "OnePlus", 120),

                createProduct("Apple Watch Ultra 3", 89999.00,
                        "Advanced smartwatch for fitness and outdoor activities",
                        "Smartwatches", "Apple", 40),

                createProduct("Lenovo Legion Pro 9", 189999.00,
                        "High-performance gaming laptop",
                        "Gaming Laptops", "Lenovo", 25),

                createProduct("Sony PlayStation 6", 69999.00,
                        "Next-generation gaming console",
                        "Gaming", "Sony", 60),

                createProduct("Xbox Series Z", 64999.00,
                        "Powerful gaming console with 4K support",
                        "Gaming", "Microsoft", 55),

                createProduct("Canon EOS R8", 124999.00,
                        "Mirrorless camera for photography enthusiasts",
                        "Cameras", "Canon", 30),

                createProduct("JBL Flip 8", 11999.00,
                        "Portable Bluetooth speaker with deep bass",
                        "Audio", "JBL", 150),

                createProduct("boAt Airdopes 901", 3999.00,
                        "Affordable wireless earbuds",
                        "Earbuds", "boAt", 200),

                createProduct("Samsung Smart TV 65 Inch", 89999.00,
                        "4K UHD Smart Television",
                        "Television", "Samsung", 35),

                createProduct("LG OLED Evo 55 Inch", 119999.00,
                        "Premium OLED smart television",
                        "Television", "LG", 25),

                createProduct("Apple iPad Mini 8", 54999.00,
                        "Compact tablet for entertainment and productivity",
                        "Tablets", "Apple", 70)
        );

        productRepository.saveAll(products);
        System.out.println("✅ Seeded " + products.size() + " sample products.");
    }

    
    private Product createProduct(String name, Double price, String description,
                                   String category, String seller, Integer stock) {
        Product p = new Product();
        p.setName(name);
        p.setPrice(price);
        p.setDescription(description);
        p.setCategory(category);
        p.setSeller(seller);
        p.setStock(stock);
        return p;
    }
}
