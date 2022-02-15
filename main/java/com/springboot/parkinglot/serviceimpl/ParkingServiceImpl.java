package com.springboot.parkinglot.serviceimpl;

import com.springboot.parkinglot.model.VehicleDTO;
import com.springboot.parkinglot.repository.ParkingRepository;
import com.springboot.parkinglot.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ParkingServiceImpl implements ParkingService {

    @Autowired
    ParkingRepository parkingRepository;

    @Override
    public List<VehicleDTO> getAllVehicles() {
        return parkingRepository.findAll();
    }

    @Override
    public String park(VehicleDTO vehicleDTO) {
        if (vehicleDTO.getId() > 0 && vehicleDTO.getId() <= 10){
            parkingRepository.save(vehicleDTO);
        }
        else {
            throw new RuntimeException("Please provide a number from 1 to 10");
        }
        return "Parked";
    }

    @Override
    public String unpark(Long id) {
        if (id > 0 && id <= 10){
            parkingRepository.deleteById(id);
        }
        else {
            throw new RuntimeException("Please provide an id from 1 to 10");
        }
        return "slot number " + id + " is now available";
    }
}
