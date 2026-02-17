package com.prahlad.jpa.service.OrderService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prahlad.jpa.dto.OrderRequestDto;
import com.prahlad.jpa.dto.OrderResponseDto;

@Service
public interface OrderService 
{  

    OrderResponseDto placeOrder(Long userId, OrderRequestDto dto);

    List<OrderResponseDto> getUserOrders(Long userId);

    OrderResponseDto getUserOrderById(Long userId, Long orderId);

}
