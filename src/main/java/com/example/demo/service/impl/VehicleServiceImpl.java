package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Vehicleentity;
import com.example.demo.repository.VehicleRepo;
import com.example.demo.service.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepo vehicleRepo;

    @Override
    public Vehicleentity addVehicle(Vehicleentity vehicle) {
        return vehicleRepo.save(vehicle);
    }
}
