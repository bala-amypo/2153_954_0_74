package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.VehicleEntity;

public interface VehicleService {

    VehicleEntity addVehicle(Long userId, VehicleEntity vehicle);

    List<VehicleEntity> getVehiclesByUser(Long userId);
}