package com.prahlad.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "users")
public class User 
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    
	public User() 
	{
		super();
	}

	public User(String name, String email) 
	{
		super();
		this.name = name;
		this.email = email;
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
    
}
