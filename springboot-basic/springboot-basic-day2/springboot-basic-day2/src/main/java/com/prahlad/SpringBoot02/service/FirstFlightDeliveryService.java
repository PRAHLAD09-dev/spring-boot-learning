package com.prahlad.SpringBoot02.service;

import org.springframework.stereotype.Service;

@Service("firstFlight")
public class FirstFlightDeliveryService implements IDeliveryService 
{

    public FirstFlightDeliveryService() 
    {
        System.out.println("FirstFlightDeliveryService Bean created");
    }

    @Override
    public boolean deliverProduct(Double amount) 
    {
        System.out.println("Product delivered via FirstFlight");
        System.out.println("Amount paid: " + amount);
        return true;
    }
}