package com.prahlad.rest.dto;

public class TouristTicketResponseDto {

    private Long touristId;
    private String name;
    private String city;
    private TicketResponseDto ticket;

    public TouristTicketResponseDto(
            Long touristId,
            String name,
            String city,
            TicketResponseDto ticket
    ) {
        this.touristId = touristId;
        this.name = name;
        this.city = city;
        this.ticket = ticket;
    }

    public Long getTouristId() {
        return touristId;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public TicketResponseDto getTicket() {
        return ticket;
    }
}