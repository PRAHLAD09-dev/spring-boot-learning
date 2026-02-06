package com.prahlad.rest.controller;

import com.prahlad.rest.dto.PaymentResponse;
import com.prahlad.rest.service.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController 
{

    private final PaymentService service;

    public PaymentController(PaymentService service) 
    {
        this.service = service;
    }

    @PostMapping("/pay")
    public PaymentResponse pay() 
    {
        return service.processPayment();
    }
}