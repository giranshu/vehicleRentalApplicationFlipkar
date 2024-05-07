package com.vehicleRental.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Branch {
    private String name;
    private List<Vehicle> vehicles = new ArrayList<>();

    public Branch(String name) {
        this.name = name;
    }

    public void addVehicle(String type, double price) {
        vehicles.add(new Vehicle(type, price));
    }

    public List<Vehicle> getAvailableVehicles(LocalDateTime startTime, LocalDateTime endTime) {
        List<Vehicle> availableVehicles = new ArrayList<>();
        // Logic to check availability based on startTime and endTime
        return availableVehicles;
    }

    public String getName() {
        return name;
    }
}
