package com.prahlad.jpa.service.Admin;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.prahlad.jpa.dto.AdminOrderItemResponseDto;
import com.prahlad.jpa.dto.AdminOrderResponseDto;
import com.prahlad.jpa.dto.AdminUserResponseDto;
import com.prahlad.jpa.dto.OrderStatusUpdateDto;
import com.prahlad.jpa.dto.PageResponseDto;


@Service
public interface AdminService 
{

	// ===================== USERS =====================
	
    List<AdminUserResponseDto> getAllUsers();
    
    AdminUserResponseDto getUserById(Long userId);
    
    void deleteUser(Long userId);
    
    List<AdminUserResponseDto> searchUsers(String keyword);
    

    // ===================== ORDERS =====================
    
    PageResponseDto<AdminOrderResponseDto> getAllOrders(Pageable pageable);
    
    AdminOrderResponseDto getOrderById(Long orderId);
    
    PageResponseDto<AdminOrderResponseDto> getOrdersByStatus(String status, Pageable pageable);
    
    AdminOrderResponseDto updateOrderStatus(Long orderId, OrderStatusUpdateDto dto);
    
    void deleteOrder(Long orderId);

    
    // ===================== ORDER ITEMS =====================
    
    List<AdminOrderItemResponseDto> getItemsByOrderId(Long orderId);
    
    List<AdminOrderItemResponseDto> getItemsWithPriceGreaterThan(double price);
}