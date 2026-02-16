package com.prahlad.rest.dto;


public class TouristResponseDto 
{

    private Long id;
    private String name;
    private String email;
    private String city;
    private String profileImage;

    public TouristResponseDto(Long id, String name, String email, String city, String profileImage) 
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.city = city;
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

	public String getCity() 
	{
		return city;
	}
}
