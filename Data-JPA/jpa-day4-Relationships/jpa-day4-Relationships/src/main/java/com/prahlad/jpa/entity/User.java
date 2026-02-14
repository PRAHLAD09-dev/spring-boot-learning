package com.prahlad.jpa.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User 
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    // One User → Many Orders
    
    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Order> orders = new ArrayList<>();

    public User() 
    {
    	
    }

    public User(String name, String email) 
    {
        this.name = name;
        this.email = email;
    }

    public void addOrder(Order order) 
    {
        orders.add(order);
        order.setUser(this);
    }

    public void removeOrder(Order order) 
    {
        orders.remove(order);
        order.setUser(null);
    }

    public Long getId() 
    {
    	return id; 
    }
    public String getName() 
    {
    	return name; 
    }
    public String getEmail() 
    {
    	return email; 
    }
    public List<Order> getOrders() 
    {
    	return orders; 
    }
}