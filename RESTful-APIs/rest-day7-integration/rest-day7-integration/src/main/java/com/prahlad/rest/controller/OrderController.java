package com.prahlad.rest.controller;

import com.prahlad.rest.dto.OrderRequest;
import com.prahlad.rest.dto.OrderResponse;
import com.prahlad.rest.model.Order;
import com.prahlad.rest.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController 
{

    private final OrderService service;

    public OrderController(OrderService service) 
    {
        this.service = service;
    }

    @PostMapping("/place")
    public OrderResponse placeOrder(@RequestBody OrderRequest request) 
    {
        return service.placeOrder(request);
    }

    @GetMapping("/all")
    public List<Order> allOrders() 
    {
        return service.getAllOrders();
    }
}