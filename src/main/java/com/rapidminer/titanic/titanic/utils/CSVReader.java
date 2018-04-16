package com.rapidminer.titanic.titanic.utils;

import com.rapidminer.titanic.titanic.passanger.Passenger;
import org.apache.logging.log4j.util.Strings;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Handles reading from .csv file
 */
public class CSVReader {

    /**
     * Read the content of the file line by line and adds it to a list
     * @param fileUrl url of the file
     * @param separator by which the content are separated
     * @return content of the file line by line in a list
     */
    private List<String[]> getFileContent(String fileUrl, String separator) {

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

    /**
     * Converts the file content into a Passenger list
     * @param fileUrl file url
     * @return list of passengers from the file
     */
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

    /**
     * Converts a list of string into passenger object
     * @param passengerString a line from the csv file
     * @return Passenger object
     */
    private Passenger stringToPassenger(String[] passengerString) {
        Passenger passenger = new Passenger();
        passenger.setPassengerClass(passengerString[0]);
        passenger.setName(passengerString[1]);
        passenger.setSex(passengerString[2]);
        passenger.setAge(convertValueToInteger(passengerString[3]));
        passenger.setNrOfSiblings(convertValueToInteger(passengerString[4]));
        passenger.setNrOfParent(convertValueToInteger(passengerString[5]));
        passenger.setTicketNumber(passengerString[6]);
        passenger.setFare(convertValueToDouble(passengerString[7]));
        passenger.setCabin(passengerString[8]);
        passenger.setEmbarkation(passengerString[9]);
        passenger.setLifeBoat(passengerString[10]);
        passenger.setSurvived(Boolean.valueOf(passengerString[11]));
        return passenger;
    }

    private Integer convertValueToInteger(String text) {
        return Strings.isEmpty(text) ? null : Double.valueOf(text).intValue();
    }

    private Double convertValueToDouble(String text) {
        return Strings.isEmpty(text) ? null : Double.valueOf(text);
    }
}
