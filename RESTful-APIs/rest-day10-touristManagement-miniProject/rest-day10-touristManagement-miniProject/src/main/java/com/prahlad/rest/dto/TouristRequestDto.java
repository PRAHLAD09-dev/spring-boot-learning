package com.prahlad.rest.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class TouristRequestDto 
{

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Invalid email")
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "City is required")
    private String city;
    
    @NotBlank(message = "destination is required")
    private String destination;
    
    @Positive(message = "Price must be grater than 0")
    private double price;


    public TouristRequestDto(String name, String email, String city , String destination, double price) 
    {
        this.name = name;
        this.email = email;
        this.city = city;
        this.destination = destination;
        this.price = price;
    }

    public String getName() 
    {
    	return name; 
    }
    public String getEmail() 
    { 
    	return email; 
    }
    public String getCity() 
    {
    	return city; 
    }

    public String getDestination() 
    {
    	return destination; 
    }
    
    public double getPrice() 
    {
    	return price; 
    }
}

