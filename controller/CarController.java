package com.example.endtermoop.controller;

import com.example.endtermoop.model.Car;
import com.example.endtermoop.model.EconomyCar;
import com.example.endtermoop.model.LuxuryCar;
import com.example.endtermoop.service.RentalService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    private final RentalService rentalService;

    public CarController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping
    public List<Car> getAllCars() {
        return rentalService.getAllCars();
    }

    @PostMapping
    public ResponseEntity<Void> createCar(@RequestBody Map<String, Object> body) {

        String name = body.get("name").toString();
        double pricePerDay = Double.parseDouble(body.get("pricePerDay").toString());
        boolean available = Boolean.parseBoolean(body.get("available").toString());
        String entityType = body.get("entityType").toString();

        Car car;

        if (entityType.equalsIgnoreCase("LUXURY")) {
            car = new LuxuryCar(0, name, pricePerDay, available);
        } else if (entityType.equalsIgnoreCase("ECONOMY")) {
            car = new EconomyCar(0, name, pricePerDay, available);
        } else {
            return ResponseEntity.badRequest().build();
        }

        rentalService.addCar(car);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable int id) {
        rentalService.deleteCar(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/price")
    public ResponseEntity<Void> updatePrice(
            @PathVariable int id,
            @RequestParam double price
    ) {
        rentalService.updateCarPrice(id, price);
        return ResponseEntity.ok().build();
    }
}
