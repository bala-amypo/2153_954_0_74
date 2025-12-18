package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Vehicleentity;
import com.example.demo.service.VehicleService;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/add")
    public Vehicleentity addVehicle(@RequestBody Vehicleentity vehicle) {
        return vehicleService.addVehicle(vehicle);
    }
}
