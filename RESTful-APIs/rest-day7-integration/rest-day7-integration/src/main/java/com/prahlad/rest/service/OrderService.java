package com.prahlad.rest.service;

import com.prahlad.rest.dto.*;
import com.prahlad.rest.model.Order;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService 
{

    private final List<Order> orders = new ArrayList<>();

    public OrderResponse placeOrder(OrderRequest request) 
    {

        Order order = new Order(
                request.getOrderId(),
                request.getAmount()
        );
        orders.add(order);

     
        RestTemplate restTemplate = new RestTemplate();
        PaymentResponse payment =
                restTemplate.postForObject(
                        "http://localhost:8080/payment/pay",
                        null,
                        PaymentResponse.class
                );

        return new OrderResponse(
                "SUCCESS",
                "Order placed successfully",
                order,
                payment
        );
    }

    public List<Order> getAllOrders() 
    {
        return orders;
    }
}