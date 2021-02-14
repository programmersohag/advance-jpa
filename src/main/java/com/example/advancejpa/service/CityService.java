package com.example.advancejpa.service;

import com.example.advancejpa.model.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CityService {

    Page<City> searchCity(Pageable pageable, Integer id, String name);
}
