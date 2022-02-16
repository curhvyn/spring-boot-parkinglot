package com.springboot.parkinglot.serviceimpl;

import com.springboot.parkinglot.model.VehicleDTO;
import com.springboot.parkinglot.repository.ParkingRepository;
import com.springboot.parkinglot.service.ParkingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ParkingServiceImpl implements ParkingService {

    final
    ParkingRepository parkingRepository;

    public ParkingServiceImpl(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }

    @Override
    public List<VehicleDTO> getAllVehicles() {
        return parkingRepository.findAll();
    }

    @Override
    public String park(VehicleDTO vehicleDTO) {
        if (vehicleDTO.getId() > 0 && vehicleDTO.getId() <= 10) {
            List<VehicleDTO> dtos = parkingRepository.findAll();
            for (VehicleDTO dto : dtos) {
                if (!Objects.equals(dto.getId(), vehicleDTO.getId())) {
                    parkingRepository.save(vehicleDTO);
                } else {
                    throw new RuntimeException(vehicleDTO.getId() + " slot is not vacant");
                }
            }
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
