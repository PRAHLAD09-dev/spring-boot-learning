package com.prahlad.rest.controller;

import com.prahlad.rest.dto.TicketResponseDto;
import com.prahlad.rest.service.TicketService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tickets")
public class TicketController 
{

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) 
    {
        this.ticketService = ticketService;
    }

    @PostMapping("/book")
    public TicketResponseDto bookTicket(
            @RequestParam Long touristId,
            @RequestParam String destination,
            @RequestParam double price) 
    {

        return ticketService.bookTicket(
                touristId, destination, price);
    }
}