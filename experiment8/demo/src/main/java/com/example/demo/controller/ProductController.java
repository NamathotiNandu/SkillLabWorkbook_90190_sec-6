package com.example.demo.controller;
import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductRepository repo;
    @GetMapping("/category/{category}")
    public List<Product> getByCategory(@PathVariable String category) {
        return repo.findByCategory(category);
    }
    @GetMapping("/filter")
    public List<Product> filter(@RequestParam double min, @RequestParam double max) {
        return repo.findByPriceBetween(min, max);
    }
    @GetMapping("/sorted")
    public List<Product> sorted() {
        return repo.findAllSortedByPrice();
    }
    @GetMapping("/expensive/{price}")
    public List<Product> expensive(@PathVariable double price) {
        return repo.findExpensiveProducts(price);
    }
}