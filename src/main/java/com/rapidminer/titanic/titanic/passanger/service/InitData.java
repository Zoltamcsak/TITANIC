package com.rapidminer.titanic.titanic.passanger.service;

import com.rapidminer.titanic.titanic.passanger.Passenger;
import com.rapidminer.titanic.titanic.utils.CSVReader;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.net.URL;
import java.util.List;

@Component
public class InitData {

    private PassengerService passengerService;

    private CSVReader reader = new CSVReader();

    public InitData(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    /**
     * Loads the content of the file and saves it into the DB
     */
    @PostConstruct
    public void init() {
        String filename = "/assets/titanic.csv";
        URL resource = InitData.class.getResource(filename);
        List<Passenger> passengers = reader.getPassengersFromFile(resource.getPath());
        passengerService.save(passengers);
    }
}
