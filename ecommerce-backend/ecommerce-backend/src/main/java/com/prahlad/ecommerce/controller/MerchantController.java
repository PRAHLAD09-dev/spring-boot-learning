package com.prahlad.ecommerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/merchant")
public class MerchantController 
{

    @GetMapping("/panel")
    public String merchantPanel() 
    {
        return "Merchant panel accessed";
    }
}