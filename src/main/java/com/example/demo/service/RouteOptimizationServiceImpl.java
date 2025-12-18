package com.example.demo.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.demo.entity.RouteOptimizationEntity;
import com.example.demo.entity.ShipmentEntity;

import com.example.demo.repository.RouteOptimizationResultRepository;
import com.example.demo.repository.ShipmentRepository;

@Service
public class RouteOptimizationServiceImpl implements RouteOptimizationService {

    private final RouteOptimizationResultRepository resultRepository;
    private final ShipmentRepository shipmentRepository;

    public RouteOptimizationServiceImpl(
            RouteOptimizationResultRepository resultRepository,
            ShipmentRepository shipmentRepository) {
        this.resultRepository = resultRepository;
        this.shipmentRepository = shipmentRepository;
    }

    @Override
    public RouteOptimizationEntity optimizeRoute(Long shipmentId) {

        ShipmentEntity shipment = shipmentRepository.findById(shipmentId).orElse(null);
        if (shipment == null) {
            return null; // Return null if shipment not found
        }

        RouteOptimizationEntity result = new RouteOptimizationEntity();
        result.setShipment(shipment);
        result.setOptimizedDistanceKm(120.0);
        result.setEstimatedFuelUsage(8.5);
        result.setGeneratedAt(LocalDateTime.now());

        return resultRepository.save(result);
    }

    @Override
    public RouteOptimizationEntity getResultById(Long id) {
        // Return null if result not found
        return resultRepository.findById(id).orElse(null);
    }
}