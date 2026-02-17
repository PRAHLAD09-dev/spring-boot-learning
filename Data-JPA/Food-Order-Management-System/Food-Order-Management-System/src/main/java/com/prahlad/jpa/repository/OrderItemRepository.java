package com.prahlad.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.prahlad.jpa.entity.OrderItem;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> 
{
	  List<OrderItem> findByPriceGreaterThan(double price);
	
	  @Query("""
		       select oi from OrderItem oi
		       join oi.order o
		       where o.id = :orderId
		       """)
		List<OrderItem> fetchItemsByOrder(Long orderId);
	 
}
