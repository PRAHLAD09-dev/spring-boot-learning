package com.prahlad.jpa.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order 
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String product;
    private double price;

    // Many Orders → One User
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore  
    private User user;

    public Order() 
    {
    	
    }

    public Order(String product, double price) 
    {
        this.product = product;
        this.price = price;
    }

    
    public Long getId() 
    {
    	return id; 
    }
    public String getProduct() 
    {
    	return product; 
    }
    public double getPrice() 
    {
    	return price; 
    }

    public void setUser(User user) 
    {
        this.user = user;
    }

	public User getUser() 
	{
		return user;
	}
    
    
}