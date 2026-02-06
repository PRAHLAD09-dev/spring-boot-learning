package com.prahlad.rest.service;

import com.prahlad.rest.dto.PaymentResponse;
import org.springframework.stereotype.Service;

@Service
public class PaymentService 
{

    public PaymentResponse processPayment() 
    {
        return new PaymentResponse(
                "PAID",
                "Payment processed successfully"
        );
    }
}