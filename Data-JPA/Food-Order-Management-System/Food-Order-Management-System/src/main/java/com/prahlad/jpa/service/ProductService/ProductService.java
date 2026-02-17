package com.prahlad.jpa.service.ProductService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prahlad.jpa.dto.ProductRequestDto;
import com.prahlad.jpa.dto.ProductResponseDto;
import com.prahlad.jpa.entity.Product;

@Service
public interface ProductService 
{

    ProductResponseDto createProduct(ProductRequestDto dto);

    ProductResponseDto updateProduct(Long productId, ProductRequestDto dto);

    void deleteProduct(Long productId);

    List<ProductResponseDto> getAllProducts();

    Product getProductEntity(Long productId); 
}