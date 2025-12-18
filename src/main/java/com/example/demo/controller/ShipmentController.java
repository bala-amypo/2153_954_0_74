package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.ShipmentEntity;
import com.example.demo.service.ShipmentService;

@RestController
@RequestMapping("/shipments")
public class ShipmentController {

    private final ShipmentService shipmentService;

    public ShipmentController(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }

    @PostMapping("/{vehicleId}")
    public ShipmentEntity createShipment(@PathVariable Long vehicleId,
                                         @RequestBody ShipmentEntity shipment) {
        return shipmentService.createShipment(vehicleId, shipment);
    }

    @GetMapping("/{shipmentId}")
    public ShipmentEntity getShipment(@PathVariable Long shipmentId) {
        return shipmentService.getShipmentById(shipmentId);
    }
}