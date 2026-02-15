package com.prahlad.jpa.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "vaccines")
public class Vaccine 
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String company;
    private double price;

    public Vaccine() 
    {
    }

    public Vaccine(String name, String company, double price) 
    {
        this.name = name;
        this.company = company;
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

    public String getCompany() 
    {
        return company;
    }

    public double getPrice() 
    {
        return price;
    }
}