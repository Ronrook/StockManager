package com.ronrook.StockManager.infrastructure.controllers;

import com.ronrook.StockManager.application.ports.in.DTO.ProductRequest;
import com.ronrook.StockManager.application.ports.in.IProductServicePort;
import com.ronrook.StockManager.application.ports.in.DTO.ProductResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {


    private final IProductServicePort productService;

    public ProductController(IProductServicePort productService) {
        this.productService = productService;
    }

    @PostMapping
    public ProductResponse addProduct(@RequestBody ProductRequest product) {
        return productService.addProduct(product);
    }

    @GetMapping("/{id}")
    public ProductResponse getProduct(@PathVariable String id) {
        return productService.getProduct(id);
    }

    @GetMapping
    public List<ProductResponse> listProducts() {
        return productService.listProducts();
    }

    @DeleteMapping("/{id}")
    public void removeProduct(@PathVariable String id) {
        productService.removeProduct(id);
    }

    @PutMapping("/{id}/quantity")
    public void updateProductQuantity(@PathVariable String id, @RequestParam int quantity) {
        productService.updateProductQuantity(id, quantity);
    }
}