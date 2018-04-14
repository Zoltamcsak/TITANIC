package com.rapidminer.titanic.titanic.passanger.resource;

import com.rapidminer.titanic.titanic.passanger.Passenger;
import com.rapidminer.titanic.titanic.passanger.service.PassengerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
