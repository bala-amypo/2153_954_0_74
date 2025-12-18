package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.LocationEntity;
import com.example.demo.service.LocationService;

@RestController
@RequestMapping("/locations")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping
    public LocationEntity createLocation(@RequestBody LocationEntity location) {
        return locationService.createLocation(location);
    }

    @GetMapping
    public List<LocationEntity> getAllLocations() {
        return locationService.getAllLocations();
    }
}