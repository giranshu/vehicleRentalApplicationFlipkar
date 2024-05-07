package com.vehicleRental.model;

public class Vehicle {
    private String type;
    private double price;

    public Vehicle(String type, double price) {
        this.type = type;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }
}
