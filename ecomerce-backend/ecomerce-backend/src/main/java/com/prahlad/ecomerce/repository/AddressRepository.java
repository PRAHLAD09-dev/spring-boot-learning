package com.prahlad.ecomerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prahlad.ecomerce.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>
{
	
}
