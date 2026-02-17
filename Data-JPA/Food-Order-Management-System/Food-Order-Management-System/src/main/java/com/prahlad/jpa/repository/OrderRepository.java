package com.prahlad.jpa.repository;

import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prahlad.jpa.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> 
{

    Page<Order> findAll(Pageable pageable);

    Page<Order> findByStatus(String status,Pageable  pageable);


    @Query("""
        select o from Order o
        left join fetch o.items
        where o.id = :orderId
    """)
    Order findWithItems(@Param("orderId") Long orderId);
    
}