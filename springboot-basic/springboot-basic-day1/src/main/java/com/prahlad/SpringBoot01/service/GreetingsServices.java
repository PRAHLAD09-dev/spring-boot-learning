package com.prahlad.SpringBoot01.service;

import java.time.LocalTime;

import org.springframework.stereotype.Service;

@Service
public class GreetingsServices implements IGreetings 
{

	
	    private  LocalTime time;

	  
	    public GreetingsServices(LocalTime time) 
	    {
	        this.time = time;
	        
	        System.out.println("Greetings service bean creted");
	    }

	    @Override
	    public String generateWish(String name) {

	        int hour = time.getHour();

	        if (hour < 12) {
	            return "Good Morning " + name;
	        } else if (hour < 16) {
	            return "Good Afternoon " + name;
	        } else if (hour < 20) {
	            return "Good Evening " + name;
	        } else {
	            return "Good Night " + name;
	        }
	    }
	}