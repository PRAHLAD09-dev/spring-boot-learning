package com.prahlad.rest.dto;

public class TicketResponseDto 
{

    private Long ticketId;
    private String destination;
    private double price;

    public TicketResponseDto(Long ticketId, String destination,double price) 
    {
        this.ticketId = ticketId;
        this.destination = destination;
        this.price = price;
    }

    public Long getTicketId() 
    {
        return ticketId;
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