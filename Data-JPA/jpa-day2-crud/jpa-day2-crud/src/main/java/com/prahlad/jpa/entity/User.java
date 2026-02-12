package com.prahlad.jpa.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User 
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;


	protected User() 
	{

	}

	public User(String name, String email) 
	{
		super();
		this.name = name;
		this.email = email;
	}

	public User(Long id, String name, String email) 
	{
		super();
		this.id = id;
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
