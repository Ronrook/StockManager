package com.ronrook.StockManager.infrastructure.controllers;

import com.ronrook.StockManager.application.ports.in.DTO.CreateProductDTO;
import com.ronrook.StockManager.application.ports.in.IProductServicePort;
import com.ronrook.StockManager.application.ports.out.ProductResponseDTO;
import com.ronrook.StockManager.domain.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {


    private final IProductServicePort productUseCase;

    public ProductController(IProductServicePort productUseCase) {
        this.productUseCase = productUseCase;
    }

    @PostMapping
    public ProductResponseDTO addProduct(@RequestBody CreateProductDTO product) {
        System.out.println("product = " + product);
        return productUseCase.addProduct(product);
    }

    @GetMapping("/{id}")
    public ProductResponseDTO getProduct(@PathVariable String id) {
        return productUseCase.getProduct(id);
    }

    @GetMapping
    public List<ProductResponseDTO> listProducts() {
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