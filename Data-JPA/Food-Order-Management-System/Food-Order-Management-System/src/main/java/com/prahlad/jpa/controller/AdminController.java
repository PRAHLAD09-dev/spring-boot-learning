package com.prahlad.jpa.controller;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.prahlad.jpa.dto.*;
import com.prahlad.jpa.service.Admin.AdminService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/admin")
public class AdminController 
{
	 private final AdminService adminService;
	  

    public AdminController(AdminService adminService) 
    {
	this.adminService = adminService;
    }

	// ===================== USERS =====================

    @GetMapping("/users")
    public ResponseEntity<List<AdminUserResponseDto>> getAllUsers() 
    {
        return ResponseEntity.ok(adminService.getAllUsers());
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<AdminUserResponseDto> getUserById(
            @PathVariable Long userId) 
    {

        return ResponseEntity.ok(adminService.getUserById(userId));
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<Void> deleteUser(
            @PathVariable Long userId) 
    {

    	adminService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/users/search")
    public ResponseEntity<List<AdminUserResponseDto>> searchUsers(
            @RequestParam String keyword) 
    {

        return ResponseEntity.ok(adminService.searchUsers(keyword));
    }

    // ===================== ORDERS =====================

    @GetMapping("/orders")
    public ResponseEntity<PageResponseDto<AdminOrderResponseDto>> getAllOrders(
            Pageable pageable)
    {

        return ResponseEntity.ok(adminService.getAllOrders(pageable));
    }

    @GetMapping("/orders/{orderId}")
    public ResponseEntity<AdminOrderResponseDto> getOrderById(
            @PathVariable Long orderId) 
    {

        return ResponseEntity.ok(adminService.getOrderById(orderId));
    }

    @GetMapping("/orders/status/{status}")
    public ResponseEntity<PageResponseDto<AdminOrderResponseDto>> getOrdersByStatus(
            @PathVariable String status,
            Pageable pageable) 
    {

        return ResponseEntity.ok(adminService.getOrdersByStatus(status, pageable));
    }

    @PutMapping("/orders/{orderId}/status")
    public ResponseEntity<AdminOrderResponseDto> updateOrderStatus(
            @PathVariable Long orderId,
            @Valid @RequestBody OrderStatusUpdateDto dto)
    {

        return ResponseEntity.ok(adminService.updateOrderStatus(orderId, dto));
    }

    @DeleteMapping("/orders/{orderId}")
    public ResponseEntity<Void> deleteOrder(
            @PathVariable Long orderId) 
    {

    	adminService.deleteOrder(orderId);
        return ResponseEntity.noContent().build();
    }

    // ===================== ORDER ITEMS =====================

    @GetMapping("/order-items/order/{orderId}")
    public ResponseEntity<List<AdminOrderItemResponseDto>> getItemsByOrder(
            @PathVariable Long orderId) 
    {

        return ResponseEntity.ok(
        		adminService.getItemsByOrderId(orderId)
        );
    }

    @GetMapping("/order-items/price-greater-than/{price}")
    public ResponseEntity<List<AdminOrderItemResponseDto>> getItemsByPrice(
            @PathVariable double price) 
    {

        return ResponseEntity.ok(
        		adminService.getItemsWithPriceGreaterThan(price)
        );
    }
}