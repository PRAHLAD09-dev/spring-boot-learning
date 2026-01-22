package com.prahlad.SpringBoot02.service;



import org.springframework.stereotype.Service;

@Service("fedEx")
public class FedexDeliveryService implements IDeliveryService 
{

    public FedexDeliveryService() 
    {
        System.out.println("FedExDeliveryService Bean created");
    }

    @Override
    public boolean deliverProduct(Double amount) 
    {
        System.out.println("Product delivered via FedEx");
        System.out.println("Amount paid: " + amount);
        return true;
    }
}