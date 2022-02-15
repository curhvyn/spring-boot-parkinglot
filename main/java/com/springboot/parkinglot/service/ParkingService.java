package com.springboot.parkinglot.service;

import com.springboot.parkinglot.model.VehicleDTO;

import java.util.List;

public interface ParkingService {

    List<VehicleDTO> getAllVehicles();
    String park(VehicleDTO vehicleDTO);
    String unpark(Long id);
}
