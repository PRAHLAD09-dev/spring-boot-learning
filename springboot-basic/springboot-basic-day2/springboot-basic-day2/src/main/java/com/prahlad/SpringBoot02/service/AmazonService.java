package com.prahlad.SpringBoot02.service;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AmazonService 
{

    private final IDeliveryService deliveryService;

    public AmazonService(@Qualifier("fedEx") IDeliveryService deliveryService) 
    {
        this.deliveryService = deliveryService;
        System.out.println("AmazonService Bean created");
    }

    public void processOrder(Double amount) 
    {
        deliveryService.deliverProduct(amount);
    }
}