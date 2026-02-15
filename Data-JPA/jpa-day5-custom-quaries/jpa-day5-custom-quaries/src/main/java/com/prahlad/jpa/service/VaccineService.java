package com.prahlad.jpa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prahlad.jpa.entity.Vaccine;

@Service
public interface VaccineService 
{

    List<Vaccine> getByName(String name);

    List<Vaccine> getByCompany(String company);

    List<Vaccine> getPriceAbove(double price);

    List<Vaccine> searchByKeyword(String keyword);

    List<Vaccine> getByPriceRange(double min, double max);
    
    List<Vaccine> getByNameNative(String name);
}