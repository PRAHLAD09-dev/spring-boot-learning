package com.prahlad.ecommerce.service.product;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prahlad.ecommerce.dto.auth.ProductRequest;
import com.prahlad.ecommerce.entity.Product;

@Service
public interface ProductService 
{

	 Product addProduct(ProductRequest request, String merchantEmail);

	   Product updateProduct(Long productId, ProductRequest request, String merchantEmail);

	  void deleteProduct(Long productId, String merchantEmail);

       List<Product> getMyProducts(String merchantEmail);
	
}

