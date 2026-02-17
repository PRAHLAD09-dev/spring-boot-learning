package com.prahlad.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order 
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(
        mappedBy = "order",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<OrderItem> items = new ArrayList<>();

    
    public Order() 
    {

	}

	public Order(String status) 
    {
		
		this.status = status;
	}
  
   public Long getId() 
   {
		return id;
	}

	public void setId(Long id) 
	{
		this.id = id;
	}

   public String getStatus() 
   {
		return status;
	}

	public List<OrderItem> getItems() 
	{
		return items;
	}
     
	public void setStatus(String status) 
	{
		this.status = status;
	}
	public User getUser() 
	{
		return user;
	}

	public void setUser(User user) 
	{
		this.user = user;
	}

}