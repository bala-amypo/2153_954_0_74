package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.UserEntity;
import com.example.demo.entity.VehicleEntity;

import com.example.demo.repository.UserRepository;
import com.example.demo.repository.VehicleRepository;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;
    private final UserRepository userRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository,
                              UserRepository userRepository) {
        this.vehicleRepository = vehicleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public VehicleEntity addVehicle(Long userId, VehicleEntity vehicle) {

        UserEntity user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return null; // Return null if user not found
        }

        if (vehicle.getCapacityKg() <= 0) {
            throw new IllegalArgumentException("Vehicle capacity must be positive");
        }

        vehicle.setUser(user);
        return vehicleRepository.save(vehicle);
    }

    @Override
    public List<VehicleEntity> getVehiclesByUser(Long userId) {
        return vehicleRepository.findByUserId(userId);
    }
}