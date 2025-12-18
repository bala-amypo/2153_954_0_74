package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicle", uniqueConstraints = {
        @UniqueConstraint(columnNames = "vehicleNumber")
})
public class Vehicleentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Userentity user;

    private String vehicleNumber;

    private Double capacityKg;

    private Double fuelEfficiency;

    public Long getId() {
        return id;
    }

    public Userentity getUser() {
        return user;
    }

    public void setUser(Userentity user) {
        this.user = user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public Double getCapacityKg() {
        return capacityKg;
    }

    public void setCapacityKg(Double capacityKg) {
        this.capacityKg = capacityKg;
    }

    public Double getFuelEfficiency() {
        return fuelEfficiency;
    }

    public void setFuelEfficiency(Double fuelEfficiency) {
        this.fuelEfficiency = fuelEfficiency;
    }
}
