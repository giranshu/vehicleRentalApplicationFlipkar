package com.vehicleRental.services;

import java.time.LocalDateTime;

import com.vehicleRental.dto.BookingDTO;
import com.vehicleRental.dto.BranchDTO;
import com.vehicleRental.dto.SystemViewDTO;
import com.vehicleRental.dto.VehicleDTO;

public interface FlipKarService {
    void addBranch(BranchDTO branchDTO);

    void addVehicle(String branchName, VehicleDTO vehicleDTO);

    BookingDTO rentVehicle(String type, LocalDateTime startTime, LocalDateTime endTime);

    SystemViewDTO getSystemView(LocalDateTime startTime, LocalDateTime endTime);
}
