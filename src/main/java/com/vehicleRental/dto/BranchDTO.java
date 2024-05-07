package com.vehicleRental.dto;

import com.vehicleRental.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class BranchDTO {
    private String name;
    private List<Vehicle> availableVehicles = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Vehicle> getAvailableVehicles() {
        return availableVehicles;
    }

    public void setAvailableVehicles(List<Vehicle> availableVehicles) {
        this.availableVehicles = availableVehicles;
    }
}
