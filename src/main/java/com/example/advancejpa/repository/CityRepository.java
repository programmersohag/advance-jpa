package com.example.advancejpa.repository;

import com.example.advancejpa.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CityRepository extends JpaRepository<City, Integer>, JpaSpecificationExecutor<City> {
}
