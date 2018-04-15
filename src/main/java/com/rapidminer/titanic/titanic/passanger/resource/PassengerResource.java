package com.rapidminer.titanic.titanic.passanger.resource;

import com.rapidminer.titanic.titanic.passanger.Passenger;
import com.rapidminer.titanic.titanic.passanger.service.PassengerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Rest controller for mapping Passenger
 */
@RestController
@RequestMapping("/api")
public class PassengerResource {

    private final PassengerService passengerService;

    public PassengerResource(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @GetMapping("/passengers")
    public List<Passenger> getAllPassengers() {
        return passengerService.findAll();
    }

    @PostMapping("/passengers")
    public ResponseEntity<Passenger> createPassenger(@RequestBody Passenger passenger) {
        passengerService.save(passenger);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/spendings/{id}")
    public ResponseEntity<Void> deletePassenger(@PathVariable Long id) {
        passengerService.delete(id);
        return ResponseEntity.ok().build();
    }
}
