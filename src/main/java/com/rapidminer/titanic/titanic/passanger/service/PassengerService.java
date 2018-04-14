package com.rapidminer.titanic.titanic.passanger.service;

import com.rapidminer.titanic.titanic.passanger.Passenger;

import java.util.List;

/**
 * Service Interface for managing Passenger
 */
public interface PassengerService {

    /**
     * Returns all passengers
     * @return passengers
     */
    List<Passenger> findAll();

    /**
     * Get the "id" passenger
     * @param id passenger id
     * @return passenger
     */
    Passenger findOne(Long id);

    /**
     * Save a passenger
     * @param passenger
     * @return the saved passenger
     */
    Passenger save(Passenger passenger);

    List<Passenger> save(List<Passenger> passengers);

    /**
     * Deletes a passenger by id
     * @param id passenger
     */
    void delete(Long id);
}
