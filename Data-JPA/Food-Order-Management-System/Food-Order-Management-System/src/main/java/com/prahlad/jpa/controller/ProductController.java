package com.prahlad.jpa.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.prahlad.jpa.dto.ProductRequestDto;
import com.prahlad.jpa.dto.ProductResponseDto;
import com.prahlad.jpa.service.ProductService.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/admin/products")
@Validated
public class ProductController 
{

    private final ProductService productService;

    public ProductController(ProductService productService) 
    {
        this.productService = productService;
    }

    // ================= CREATE PRODUCT =================
    // POST /api/admin/products
    @PostMapping
    public ResponseEntity<ProductResponseDto> createProduct(
            @Valid @RequestBody ProductRequestDto dto)
    {

        return new ResponseEntity<>(
                productService.createProduct(dto),
                HttpStatus.CREATED
        );
    }

    // ================= UPDATE PRODUCT =================
    // PUT /api/admin/products/{productId}
    @PutMapping("/{productId}")
    public ResponseEntity<ProductResponseDto> updateProduct(
            @PathVariable Long productId,
            @Valid @RequestBody ProductRequestDto dto) 
    {

        return ResponseEntity.ok(
                productService.updateProduct(productId, dto)
        );
    }

    // ================= DELETE PRODUCT =================
    // DELETE /api/admin/products/{productId}
    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(
            @PathVariable Long productId)
    {

        productService.deleteProduct(productId);
        return ResponseEntity.noContent().build();
    }

    // ================= GET ALL PRODUCTS =================
    // GET /api/admin/products
    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> getAllProducts()
    {

        return ResponseEntity.ok(
                productService.getAllProducts()
        );
    }
}