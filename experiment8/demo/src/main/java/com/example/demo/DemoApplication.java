package com.example.demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;
import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    @Bean
    CommandLineRunner run(ProductRepository repo) {
        return args -> {
            repo.save(new Product("Laptop", "Electronics", 50000));
            repo.save(new Product("Phone", "Electronics", 20000));
            repo.save(new Product("Shirt", "Clothing", 1000));
            repo.save(new Product("Shoes", "Footwear", 3000));
            repo.save(new Product("Watch", "Accessories", 2500));
        };
    }
}