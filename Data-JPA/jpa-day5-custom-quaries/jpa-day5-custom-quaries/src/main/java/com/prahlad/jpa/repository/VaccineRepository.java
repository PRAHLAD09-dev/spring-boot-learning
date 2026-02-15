package com.prahlad.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prahlad.jpa.entity.Vaccine;

@Repository
public interface VaccineRepository extends JpaRepository<Vaccine, Long> 
{


    List<Vaccine> findByName(String name);

    List<Vaccine> findByCompany(String company);

    List<Vaccine> findByPriceGreaterThan(double price);

    List<Vaccine> findByNameContaining(String keyword);

   

    @Query("SELECT v FROM Vaccine v WHERE v.price BETWEEN :min AND :max")
    List<Vaccine> findVaccinesInRange(
            @Param("min") double min,
            @Param("max") double max
    );

  

    @Query(
        value = "SELECT * FROM vaccines WHERE name LIKE %:name%",
        nativeQuery = true
    )
    List<Vaccine> searchByNameNative(@Param("name") String name);
}