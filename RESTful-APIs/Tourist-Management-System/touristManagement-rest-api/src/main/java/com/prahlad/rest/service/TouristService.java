package com.prahlad.rest.service;

import com.prahlad.rest.dto.*;
import com.prahlad.rest.exception.BadRequestException;
import com.prahlad.rest.exception.ResourceNotFoundException;
import com.prahlad.rest.model.Tourist;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@Service
public class TouristService 
{

    private final List<Tourist> tourists = new ArrayList<>();
    private final RestTemplate restTemplate;
    private long idCounter = 1;

    public TouristService(RestTemplate restTemplate) 
    {
        this.restTemplate = restTemplate;
    }

    // ================= CREATE +  =================
    public TouristTicketResponseDto create(TouristRequestDto dto) 
    {

        if (dto.getDestination() == null || dto.getDestination().isBlank()) 
        {
            throw new BadRequestException("Destination is required");
        }
        if (dto.getPrice() <= 0) 
        {
            throw new BadRequestException("Price must be greater than zero");
        }

        Tourist tourist = new Tourist(
                idCounter++,
                dto.getName(),
                dto.getEmail(),
                dto.getCity(),
                null
        );

        tourists.add(tourist);

        TicketResponseDto ticket = bookTicket(
                tourist.getId(),
                dto.getDestination(),
                dto.getPrice()
        );

        return new TouristTicketResponseDto(
                tourist.getId(),
                tourist.getName(),
                tourist.getCity(),
                ticket
        );
    }

    // ================= READ ALL =================
    public List<TouristResponseDto> getAll() 
    {
        return tourists.stream()
                .map(this::mapToResponse)
                .toList();
    }

    // ================= READ BY ID =================
    public TouristResponseDto getById(Long id) 
    {
        Tourist tourist = findById(id);
        return mapToResponse(tourist);
    }

    // ================= UPDATE =================
    public TouristResponseDto update(Long id, TouristRequestDto dto) 
    {

        Tourist old = findById(id);

        Tourist updated = new Tourist(
                old.getId(),
                dto.getName(),
                dto.getEmail(),
                dto.getCity(),
                old.getProfileImage()
        );

        tourists.remove(old);
        tourists.add(updated);

        return mapToResponse(updated);
    }

    // ================= DELETE =================
    public void delete(Long id) {
        Tourist tourist = findById(id);
        tourists.remove(tourist);
    }

    // ================= PAGINATION =================
    public PageResponseDto<TouristResponseDto> getPaginated(int page, int size) 
    {

        int totalElements = tourists.size();
        int totalPages = (int) Math.ceil((double) totalElements / size);

        int start = page * size;
        int end = Math.min(start + size, totalElements);

        if (start >= totalElements) 
        {
            return new PageResponseDto<>(
                    List.of(),
                    page,
                    size,
                    totalElements,
                    totalPages
            );
        }

        List<TouristResponseDto> data =
                tourists.subList(start, end)
                        .stream()
                        .map(this::mapToResponse)
                        .toList();

        return new PageResponseDto<>(
                data,
                page,
                size,
                totalElements,
                totalPages
        );
    }

    // ================= API TO API  =================
    public TicketResponseDto bookTicket(
            Long touristId,
            String destination,
            double price
    ) 
    {

      String url = UriComponentsBuilder
              .fromUriString("http://localhost:8080/api/tickets/book")
              .queryParam("touristId", touristId) 
              .queryParam("destination", destination)
              .queryParam("price", price)
              .toUriString();

      return restTemplate.postForObject(
              url,
              null,
              TicketResponseDto.class
      );
    }
    
    // ================= UPDATE PROFILE IMAGE =================
    public TouristResponseDto updateProfileImage(Long id, String profileImage) 
    {

        Tourist tourist = findById(id); 

        tourist.setProfileImage(profileImage);
        return mapToResponse(tourist);
    }
    
    // ================= HELPERS =================
    private Tourist findById(Long id) 
    {
        return tourists.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElseThrow(() ->
                        new ResourceNotFoundException("Tourist not found with id: " + id)
                );
    }

    private TouristResponseDto mapToResponse(Tourist t) 
    {
        return new TouristResponseDto(
                t.getId(),
                t.getName(),
                t.getEmail(),
                t.getCity(),
                t.getProfileImage()
        );
    }
}
    