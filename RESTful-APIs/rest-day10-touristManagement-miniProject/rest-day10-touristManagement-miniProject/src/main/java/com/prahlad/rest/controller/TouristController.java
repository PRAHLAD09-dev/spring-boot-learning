package com.prahlad.rest.controller;

import com.prahlad.rest.dto.*;
import com.prahlad.rest.service.TouristService;


import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tourists")
public class TouristController 
{

    private final TouristService touristService;

    public TouristController(TouristService touristService) 
    {
        this.touristService = touristService;
    }


    @PostMapping
    public TouristTicketResponseDto create(
            @RequestBody TouristRequestDto dto) 
    {
        return touristService.create(dto);
    }

    
    @GetMapping
    public List<TouristResponseDto> getAll() {
        return touristService.getAll();
    }

    
    @GetMapping("/{id}")
    public TouristResponseDto getById(@PathVariable Long id) 
    {
        return touristService.getById(id);
    }

    
    @PutMapping("/{id}")
    public TouristResponseDto update(
            @PathVariable Long id,
            @RequestBody TouristRequestDto dto) 
    {
        return touristService.update(id, dto);
    }

   
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) 
    {
        touristService.delete(id);
    }

  
    @GetMapping("/page")
    public PageResponseDto<TouristResponseDto> paginate(
            @RequestParam int page,
            @RequestParam int size
            )
    {
        return touristService.getPaginated(page, size);
    }
}