package com.springboot.parkinglot.controller;

import com.springboot.parkinglot.model.VehicleDTO;
import com.springboot.parkinglot.service.ParkingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parkinglot")
public class ParkingLotController {

     final
    ParkingService parkingService;

    public ParkingLotController(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    @GetMapping("/parkingInfo")
    public List<VehicleDTO> getAllVehicles() {
        return parkingService.getAllVehicles();
    }

    @PostMapping("/park")
    public String park(VehicleDTO vehicleDTO) {
        return parkingService.park(vehicleDTO);
    }

    @DeleteMapping("/unpark")
    public String unpark(Long id) {
        return parkingService.unpark(id);
    }

}
