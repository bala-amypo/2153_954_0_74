package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.RouteOptimizationEntity;
import com.example.demo.service.RouteOptimizationService;

@RestController
@RequestMapping("/optimize")
public class RouteOptimizationController {

    private final RouteOptimizationService routeOptimizationService;

    public RouteOptimizationController(RouteOptimizationService routeOptimizationService) {
        this.routeOptimizationService = routeOptimizationService;
    }

    @PostMapping("/{shipmentId}")
    public RouteOptimizationEntity optimizeRoute(@PathVariable Long shipmentId) {
        return routeOptimizationService.optimizeRoute(shipmentId);
    }

    @GetMapping("/{id}")
    public RouteOptimizationEntity getResult(@PathVariable Long id) {
        return routeOptimizationService.getResultById(id);
    }
}
