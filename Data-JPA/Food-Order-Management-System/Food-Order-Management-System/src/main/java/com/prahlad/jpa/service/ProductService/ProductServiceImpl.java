package com.prahlad.jpa.service.ProductService;

import java.util.List;

//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.prahlad.jpa.dto.OrderItemRequestDto;
//import com.prahlad.jpa.dto.OrderItemResponseDto;
//import com.prahlad.jpa.entity.Order;
//import com.prahlad.jpa.entity.OrderItem;
//import com.prahlad.jpa.entity.Product;
//import com.prahlad.jpa.exception.ResourceNotFoundException;
//import com.prahlad.jpa.repository.OrderItemRepository;
//import com.prahlad.jpa.repository.OrderRepository;
//import com.prahlad.jpa.repository.ProductRepository;
//


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prahlad.jpa.dto.ProductRequestDto;
import com.prahlad.jpa.dto.ProductResponseDto;

import com.prahlad.jpa.entity.Product;
import com.prahlad.jpa.exception.ResourceNotFoundException;

import com.prahlad.jpa.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService 
{

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) 
    {
        this.productRepository = productRepository;
    }

    @Override
    public ProductResponseDto createProduct(ProductRequestDto dto) 
    {
        Product product = new Product();
        product.setName(dto.name());
        product.setPrice(dto.price());

        Product saved = productRepository.save(product);
        return mapToResponse(saved);
    }

    @Override
    public ProductResponseDto updateProduct(Long productId, ProductRequestDto dto)
    {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with this product id" + productId));

        product.setName(dto.name());
        product.setPrice(dto.price());

        return mapToResponse(product);
    }

    @Override
    public void deleteProduct(Long productId) 
    {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with this product id " + productId));

        productRepository.delete(product);
    }

    @Override
    public List<ProductResponseDto> getAllProducts() 
    {
        return productRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public Product getProductEntity(Long productId)
    {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }

    private ProductResponseDto mapToResponse(Product product) 
    {
        return new ProductResponseDto(
                product.getId(),
                product.getName(),
                product.getPrice()
        );
    }
}