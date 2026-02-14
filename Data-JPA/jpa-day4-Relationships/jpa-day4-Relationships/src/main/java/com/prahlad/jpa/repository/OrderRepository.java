package com.prahlad.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prahlad.jpa.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> 
{
	
}