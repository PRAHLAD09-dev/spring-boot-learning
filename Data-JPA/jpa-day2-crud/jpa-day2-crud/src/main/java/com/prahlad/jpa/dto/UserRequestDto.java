package com.prahlad.jpa.dto;

public class UserRequestDto 
{
    private String name;
    private String email;
    
	public UserRequestDto(String name, String email) 
	{
		super();
		this.name = name;
		this.email = email;
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