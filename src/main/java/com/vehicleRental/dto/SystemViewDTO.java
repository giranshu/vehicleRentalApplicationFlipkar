package com.vehicleRental.dto;

import java.util.ArrayList;
import java.util.List;


public class SystemViewDTO {
    private List<BranchDTO> branches = new ArrayList<>();

    public List<BranchDTO> getBranches() {
        return branches;
    }

    public void setBranches(List<BranchDTO> branches) {
        this.branches = branches;
    }
}