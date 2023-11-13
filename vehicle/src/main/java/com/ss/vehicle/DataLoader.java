package com.ss.vehicle;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final VehicleRepository vehicleRepository;

    public DataLoader(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Vehicle vehicle1 = new Vehicle("DL10AA1234", "Sedan", "Available");
        Vehicle vehicle2 = new Vehicle("AP09T5544", "Hatchback", "In Use");
        Vehicle vehicle3 = new Vehicle("KL08AA3210", "Premium SUV", "Available");
        vehicleRepository.saveAll(List.of(vehicle1, vehicle2, vehicle3));

    }
}
