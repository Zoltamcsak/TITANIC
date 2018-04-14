package com.rapidminer.titanic.titanic.utils;

import com.rapidminer.titanic.titanic.passanger.Passenger;
import org.apache.logging.log4j.util.Strings;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVReader {

    public List<String[]> getFileContent(String fileUrl, String separator) {

        Scanner scanner;
        List<String[]> passengerStrings = new ArrayList<>();
        try {
            scanner = new Scanner(new File(fileUrl));
            String line = "";
            scanner.nextLine();
            while (scanner.hasNext()) {
                line = scanner.nextLine();
                String[] passengers = line.split(separator);
                passengerStrings.add(passengers);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return passengerStrings;
    }

    public List<Passenger> getPassengersFromFile(String fileUrl) {
        List<Passenger> result = new ArrayList<>();
        String separator = ";";
        List<String[]> passengerStrings = getFileContent(fileUrl, separator);
        for (String[] passenger : passengerStrings) {
            Passenger pas = stringToPassenger(passenger);
            result.add(pas);
        }
        return result;
    }

    public Passenger stringToPassenger(String[] passengerString) {
        Passenger passenger = new Passenger();
        passenger.setPassengerClass(passengerString[0]);
        passenger.setName(passengerString[1]);
        passenger.setSex(passengerString[2]);
        passenger.setAge(!"".equals(passengerString[3]) ? Double.valueOf(passengerString[3]).intValue() : null);
        passenger.setNrOfSiblings(!"".equals(passengerString[4]) ? Double.valueOf(passengerString[4]).intValue() : null);
        passenger.setNrOfParent(!"".equals(passengerString[5]) ? Double.valueOf(passengerString[5]).intValue() : null);
        passenger.setTicketNumber(passengerString[6]);
        passenger.setFare(!Strings.isEmpty(passengerString[7]) ? Double.valueOf(passengerString[7]) : null);
        passenger.setCabin(passengerString[8]);
        passenger.setEmbarkation(passengerString[9]);
        passenger.setLifeBoat(passengerString[10]);
        passenger.setSurvived(Boolean.valueOf(passengerString[11]));
        return passenger;
    }
}
