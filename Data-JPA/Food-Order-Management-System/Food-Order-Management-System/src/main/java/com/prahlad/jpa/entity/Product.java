package com.prahlad.jpa.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product 
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    private double price;

    private boolean active = true;

    public Product() 
    {
    	
    }

    public Product(String name, double price) 
    {
        this.name = name;
        this.price = price;
    }

    public Long getId() 
    {
    	return id; 
    }
    public String getName() 
    {
    	return name; 
    }
    public double getPrice()
    {
    	return price; 
    }
    public boolean isActive() 
    {
    	return active; 
    }

    public void setName(String name) 
    {
    	this.name = name; 
    }
    public void setPrice(double price)
    {
    	this.price = price; 
    }
    public void setActive(boolean active) 
    {
    	this.active = active; 
    }
}