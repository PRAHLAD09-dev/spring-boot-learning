package com.prahlad.rest.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class User 
{

    private Integer id;

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Invalid email format")
    private String email;

    public User() 
    {
    	
    }

    public User(Integer id, String name, String email) 
    {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Integer getId() 
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

    public void setId(Integer id) 
    {
    	this.id = id; 
    }
    public void setName(String name) 
    {
    	this.name = name; 
    }
    public void setEmail(String email) 
    {
    	this.email = email; 
    }
}