package com.vehicleRental.controller;

import com.vehicleRental.dto.BookingDTO;
import com.vehicleRental.dto.BranchDTO;
import com.vehicleRental.dto.SystemViewDTO;
import com.vehicleRental.dto.VehicleDTO;
import com.vehicleRental.services.FlipKarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    @Autowired
    private FlipKarService flipKarService;

    @PostMapping("/branches")
    public ResponseEntity<Void> addBranch(@RequestBody BranchDTO branchDTO) {
        flipKarService.addBranch(branchDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/branches/{branchName}/vehicles")
    public ResponseEntity<Void> addVehicle(@PathVariable String branchName, @RequestBody VehicleDTO vehicleDTO) {
        flipKarService.addVehicle(branchName, vehicleDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/rent")
    public ResponseEntity<BookingDTO> rentVehicle(@RequestParam String type,
                                                  @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startTime,
                                                  @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endTime) {
        BookingDTO bookingDTO = flipKarService.rentVehicle(type, startTime, endTime);
        if (bookingDTO != null) {
            return new ResponseEntity<>(bookingDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/system-view")
    public ResponseEntity<SystemViewDTO> getSystemView(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startTime,
                                                       @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endTime) {
        SystemViewDTO systemViewDTO = flipKarService.getSystemView(startTime, endTime);
        return new ResponseEntity<>(systemViewDTO, HttpStatus.OK);
    }
}
