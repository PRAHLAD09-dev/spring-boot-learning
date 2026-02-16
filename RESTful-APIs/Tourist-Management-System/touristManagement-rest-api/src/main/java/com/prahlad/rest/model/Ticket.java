package com.prahlad.rest.model;

public class Ticket 
{

    private Long ticketId;
    private Long touristId;
    private String destination;
    private double price;

    public Ticket(Long ticketId, Long touristId, String destination, double price) 
    {
        this.ticketId = ticketId;
        this.touristId = touristId;
        this.destination = destination;
        this.price = price;
    }

    public Long getTicketId() 
    {
    	return ticketId; 
    }
    public Long getTouristId() 
    {
    	return touristId; 
    }
    public String getDestination() 
    {
    	return destination; 
    }
    public double getPrice() 
    {
    	return price; 
    }
}