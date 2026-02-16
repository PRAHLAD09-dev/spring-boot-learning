package com.prahlad.rest.model;

public class Tourist 
{

    private Long id;
    private String name;
    private String email;
    private String city;
    private String profileImage;

    public Tourist(Long id, String name, String email,String city , String profileImage) 
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
    public String getCity() 
    {
		return city;
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