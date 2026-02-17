package com.prahlad.jpa.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.prahlad.jpa.dto.OrderRequestDto;
import com.prahlad.jpa.dto.OrderResponseDto;
import com.prahlad.jpa.dto.UserRequestDto;
import com.prahlad.jpa.dto.UserResponseDto;
import com.prahlad.jpa.service.OrderService.OrderService;
import com.prahlad.jpa.service.UserService.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
@Validated
public class UserController 
{

	
	private final UserService userService;
	private final OrderService orderservice;
	
    public UserController( UserService userService ,OrderService orderservice) 
    {
		
		this.userService = userService;
		this.orderservice = orderservice;
	}

	// ================= USER CRUD =================

    // CREATE USER
    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(
            @Valid @RequestBody UserRequestDto dto) 
    {

        return new ResponseEntity<>(
                userService.createUser(dto),
                HttpStatus.CREATED
        );
    }

    // GET USER BY ID
    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseDto> getUserById(
            @PathVariable Long userId) 
    {

    	
        return ResponseEntity.ok(
                userService.getUserById(userId)
        );
    }

    // UPDATE USER
    @PutMapping("/{userId}")
    public ResponseEntity<UserResponseDto> updateUser(
            @PathVariable Long userId,
            @Valid @RequestBody UserRequestDto dto) 
    {

        return ResponseEntity.ok(
                userService.updateUser(userId, dto)
        );
    }

    // DELETE USER
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(
            @PathVariable Long userId)
    {

        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    // ================= USER → ORDER =================

    // PLACE ORDER 
    @PostMapping("/{userId}/orders")
    public ResponseEntity<OrderResponseDto> placeOrder(
            @PathVariable Long userId,
            @Valid @RequestBody OrderRequestDto dto)
    {

        return new ResponseEntity<>(
        		orderservice.placeOrder(userId, dto),
                HttpStatus.CREATED
        );
    }

    // GET ALL ORDERS OF USER
    @GetMapping("/{userId}/orders")
    public ResponseEntity<List<OrderResponseDto>> getUserOrders(
            @PathVariable Long userId) 
    {

        return ResponseEntity.ok(
        		orderservice.getUserOrders(userId)
        );
    }

    // GET SINGLE ORDER OF USER
    @GetMapping("/{userId}/orders/{orderId}")
    public ResponseEntity<OrderResponseDto> getUserOrderById(
            @PathVariable Long userId,
            @PathVariable Long orderId)
    {

        return ResponseEntity.ok(
        		orderservice.getUserOrderById(userId, orderId)
        );
    }
}