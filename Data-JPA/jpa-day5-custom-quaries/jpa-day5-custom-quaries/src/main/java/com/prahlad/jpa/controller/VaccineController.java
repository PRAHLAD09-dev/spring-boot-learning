package com.prahlad.jpa.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prahlad.jpa.entity.Vaccine;
import com.prahlad.jpa.service.VaccineService;

@RestController
@RequestMapping("/api/vaccines")
public class VaccineController 
{

    private final VaccineService service;

    public VaccineController(VaccineService service)
    {
        this.service = service;
    }

    @GetMapping("/name")
    public List<Vaccine> byName(@RequestParam String name) 
    {
        return service.getByName(name);
    }

    @GetMapping("/company")
    public List<Vaccine> byCompany(@RequestParam String company) 
    {
        return service.getByCompany(company);
    }

    @GetMapping("/above")
    public List<Vaccine> PriceAbove(@RequestParam double price) 
    {
        return service.getPriceAbove(price);
    }

    @GetMapping("/search")
    public List<Vaccine> search(@RequestParam String keyword) 
    {
        return service.searchByKeyword(keyword);
    }

    @GetMapping("/range")
    public List<Vaccine> range(
            @RequestParam double min,
            @RequestParam double max
    ) 
    {
        return service.getByPriceRange(min, max);
    }
    
    @GetMapping("/native")
    public List<Vaccine> NameNative(@RequestParam String name)
    {
    	return service.getByNameNative(name);
    }
}