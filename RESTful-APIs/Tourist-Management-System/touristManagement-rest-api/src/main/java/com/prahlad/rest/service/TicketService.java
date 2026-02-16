package com.prahlad.rest.service;

import org.springframework.stereotype.Service;

import com.prahlad.rest.dto.TicketResponseDto;

@Service
public class TicketService 
{

    private long counter = 100;

    public TicketResponseDto bookTicket(
            Long touristId,
            String destination,
            double price
    ) 
    {
        return new TicketResponseDto(
                counter++,
                destination,
                price
        );
    }
}