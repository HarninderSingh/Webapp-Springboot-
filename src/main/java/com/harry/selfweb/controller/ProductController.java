package com.harry.selfweb.controller;

import com.harry.selfweb.model.Product;
import com.harry.selfweb.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    public String showProducts(Model model) {
        List<Product> products = productRepository.findAll();  // Fetch from DB
        model.addAttribute("products", products);
        return "products"; // Load products.html
    }
}
