package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.LocationEntity;
import com.example.demo.repository.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public LocationEntity createLocation(LocationEntity location) {
        if (location.getLatitude() < -90 || location.getLatitude() > 90) {
            throw new IllegalArgumentException("Invalid latitude value");
        }
        return locationRepository.save(location);
    }

    @Override
    public List<LocationEntity> getAllLocations() {
        return locationRepository.findAll();
    }

    @Override
    public LocationEntity getLocationById(Long id) {
        // Returns null if not found instead of throwing an exception
        return locationRepository.findById(id).orElse(null);
    }
}