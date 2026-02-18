package com.prahlad.rest.model;

public class User {

    private Long id;
    private String name;
    private String email;
    private String profileImage;
    
	public User(Long id, String name, String email, String profileImage) 
	{
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.profileImage = profileImage;
	}
	public Long getId() 
	{
		return id;
	}
	public void setId(Long id) 
	{
		this.id = id;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getEmail() 
	{
		return email;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}
	public String getProfileImage() 
	{
		return profileImage;
	}
	public void setProfileImage(String profileImage) 
	{
		this.profileImage = profileImage;
	}

    
}