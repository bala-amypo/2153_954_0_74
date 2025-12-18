package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Vehicleentity;

public interface VehicleRepo extends JpaRepository<Vehicleentity, Long> {
    boolean existsByVehicleNumber(String vehicleNumber);
}
