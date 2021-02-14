package com.example.advancejpa.service_impl;

import com.example.advancejpa.model.City;
import com.example.advancejpa.specification.GenericSpecificationsBuilder;
import com.example.advancejpa.specification.SpecificationFactory;
import com.example.advancejpa.repository.CityRepository;
import com.example.advancejpa.service.CityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CityServiceImpl implements CityService {

    private final SpecificationFactory<City> userSpecificationFactory;

    private final CityRepository cityRepository;

    public CityServiceImpl(SpecificationFactory<City> userSpecificationFactory, CityRepository cityRepository) {
        this.userSpecificationFactory = userSpecificationFactory;
        this.cityRepository = cityRepository;
    }

    @Override
    public Page<City> searchCity(Pageable pageable, Integer id, String name) {
        GenericSpecificationsBuilder<City> builder = new GenericSpecificationsBuilder<>();
        if (Objects.nonNull(id)) {
            builder.with(userSpecificationFactory.isEqual("account", id));
        }
        if (!name.isEmpty()) {
            builder.with(userSpecificationFactory.isLike("name", name));
        }
        return cityRepository.findAll(builder.build(), pageable);
    }
}

