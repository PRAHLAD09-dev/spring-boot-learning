package com.prahlad.rest.controller;

import com.prahlad.rest.dto.*;
import com.prahlad.rest.service.FileService;
import com.prahlad.rest.service.TouristService;

import java.io.IOException;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/tourists")
public class TouristController 
{

    private final TouristService touristService;
    private final FileService fileService;

    public TouristController(TouristService touristService , FileService fileService) 
    {
        this.touristService = touristService;
        this.fileService = fileService;
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
    
    @PostMapping(
            value = "/{id}/upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public TouristResponseDto uploadProfileImage(
            @PathVariable Long id,
            @RequestPart("file") MultipartFile file
    ) throws IOException 
    {

        String imagepath = fileService.upload(file);
        return touristService.updateProfileImage(id, imagepath);
    }
}