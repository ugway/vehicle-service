package com.ss.vehicle;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

 @Autowired
 private VehicleRepository vehicleRepository;

 @GetMapping
 public List<Vehicle> getAllVehicles() {
     return vehicleRepository.findAll();
 }

 @GetMapping("/{vehicleId}")
 public ResponseEntity<Vehicle> getVehicle(@PathVariable Long vehicleId) {
     Optional<Vehicle> vehicle = vehicleRepository.findById(vehicleId);
     return vehicle.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
 }
}

