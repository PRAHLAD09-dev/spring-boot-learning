package com.prahlad.rest.dto;

import com.prahlad.rest.model.Order;

public class OrderResponse 
{

    private String status;
    private String message;
    private Order order;
    private PaymentResponse payment;

    public OrderResponse(String status, String message,
                         Order order,
                         PaymentResponse payment) 
    {
        this.status = status;
        this.message = message;
        this.order = order;
        this.payment = payment;
    }

    public String getStatus() 
    {
        return status;
    }

    public String getMessage() 
    {
        return message;
    }

    public Order getOrder() 
    {
        return order;
    }

    public PaymentResponse getPayment() 
    {
        return payment;
    }
}