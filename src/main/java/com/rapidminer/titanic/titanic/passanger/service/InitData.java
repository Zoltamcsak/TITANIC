package com.rapidminer.titanic.titanic.passanger.service;

import com.rapidminer.titanic.titanic.TitanicApplication;
import com.rapidminer.titanic.titanic.passanger.Passenger;
import com.rapidminer.titanic.titanic.utils.CSVReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

@Component
public class InitData {

    private PassengerService passengerService;

    private CSVReader reader = new CSVReader();

    public InitData(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @PostConstruct
    public void init() throws IOException {
        String filename = "/assets/titanic.csv";
        URL resource = InitData.class.getResource(filename);
        List<Passenger> passengers = reader.getPassengersFromFile(resource.getPath());
        passengerService.save(passengers);
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaa" + passengers.size());
    }
}
