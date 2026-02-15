package com.prahlad.jpa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prahlad.jpa.entity.Vaccine;
import com.prahlad.jpa.repository.VaccineRepository;

@Service
public class VaccineServiceImpl implements VaccineService 
{

    private final VaccineRepository repository;

    public VaccineServiceImpl(VaccineRepository repository) 
    {
        this.repository = repository;
    }

    @Override
    public List<Vaccine> getByName(String name) 
    {
        return repository.findByName(name);
    }

    @Override
    public List<Vaccine> getByCompany(String company) 
    {
        return repository.findByCompany(company);
    }

    @Override
    public List<Vaccine> getPriceAbove(double price) 
    {
        return repository.findByPriceGreaterThan(price);
    }

    @Override
    public List<Vaccine> searchByKeyword(String keyword) 
    {
        return repository.findByNameContaining(keyword);
    }

    @Override
    public List<Vaccine> getByPriceRange(double min, double max) 
    {
        return repository.findVaccinesInRange(min, max);
    }

	@Override
	public List<Vaccine> getByNameNative(String name) 
	{
		
		return repository.searchByNameNative(name);
	}
}