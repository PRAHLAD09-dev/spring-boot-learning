package com.prahlad.ecomerce.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.prahlad.ecomerce.entity.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> 
{
    List<Product> findByCategoryId(Long categoryId);
}