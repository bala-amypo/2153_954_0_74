package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.RouteOptimizationEntity;

public interface RouteOptimizationResultRepository
        extends JpaRepository<RouteOptimizationEntity, Long> {
}