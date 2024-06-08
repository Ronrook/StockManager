package com.ronrook.StockManager.infrastructure.controllers;

import com.ronrook.StockManager.application.usecases.ProductUseCase;
import com.ronrook.StockManager.domain.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductUseCase productUseCase;

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productUseCase.addProduct(product);
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable String id) {
        return productUseCase.getProduct(id);
    }

    @GetMapping
    public List<Product> listProducts() {
        return productUseCase.listProducts();
    }

    @DeleteMapping("/{id}")
    public void removeProduct(@PathVariable String id) {
        productUseCase.removeProduct(id);
    }

    @PutMapping("/{id}/quantity")
    public void updateProductQuantity(@PathVariable String id, @RequestParam int quantity) {
        productUseCase.updateProductQuantity(id, quantity);
    }
}