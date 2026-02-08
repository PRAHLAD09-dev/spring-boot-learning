package com.prahlad.rest.dto;

public class UserResponseDto 
{

    private Long id;
    private String name;
    private String email;
    private String profileImage;
    
	public UserResponseDto(Long id, String name, String email, String profileImage) 
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

	public String getName() 
	{
		return name;
	}

	public String getEmail() 
	{
		return email;
	}

	public String getProfileImage() 
	{
		return profileImage;
	}
    
}