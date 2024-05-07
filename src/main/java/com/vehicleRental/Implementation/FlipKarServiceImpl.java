package com.vehicleRental.Implementation;

import com.vehicleRental.dto.BookingDTO;
import com.vehicleRental.dto.BranchDTO;
import com.vehicleRental.dto.SystemViewDTO;
import com.vehicleRental.dto.VehicleDTO;
import com.vehicleRental.model.Branch;
import com.vehicleRental.model.Vehicle;
import com.vehicleRental.services.FlipKarService;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FlipKarServiceImpl implements FlipKarService {
    private final Map<String, Branch> branches = new HashMap<>();

    @Override
    public void addBranch(BranchDTO branchDTO) {
        Branch branch = new Branch(branchDTO.getName());
        for (Vehicle vehicle : branchDTO.getAvailableVehicles()) {
           
            String type = vehicle.getType();
            double price = vehicle.getPrice();
           
                branch.addVehicle(type, price);
           
        }
        branches.put(branchDTO.getName(), branch);
    }


    @Override
    public void addVehicle(String branchName, VehicleDTO vehicleDTO) {
        branches.get(branchName).addVehicle(vehicleDTO.getType(), vehicleDTO.getPrice());
    }

    @Override
    public BookingDTO rentVehicle(String type, LocalDateTime startTime, LocalDateTime endTime) {
        for (Branch branch : branches.values()) {
            List<Vehicle> availableVehicles = branch.getAvailableVehicles(startTime, endTime);
            for (Vehicle vehicle : availableVehicles) {
                if (vehicle.getType().equals(type)) {
                    BookingDTO bookingDTO = new BookingDTO();
                    bookingDTO.setBranchName(branch.getName());
                    bookingDTO.setVehicleType(type);
                    bookingDTO.setStartTime(startTime);
                    bookingDTO.setEndTime(endTime);
                    return bookingDTO;
                }
            }
        }
        return null;
    }

    @Override
    public SystemViewDTO getSystemView(LocalDateTime startTime, LocalDateTime endTime) {
        SystemViewDTO systemViewDTO = new SystemViewDTO();
        for (Branch branch : branches.values()) {
            BranchDTO branchDTO = new BranchDTO();
            branchDTO.setName(branch.getName());
            branchDTO.setAvailableVehicles(branch.getAvailableVehicles(startTime, endTime));
            systemViewDTO.getBranches().add(branchDTO);
        }
        return systemViewDTO;
    }

//	@Override
//	public void addVehicle1(String branchName, VehicleDTO vehicleDTO) {
//		// TODO Times up
//	
//	}
}

