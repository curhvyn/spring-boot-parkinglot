package com.springboot.parkinglot.repository;

import com.springboot.parkinglot.model.VehicleDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRepository extends JpaRepository <VehicleDTO, Long> {
}
