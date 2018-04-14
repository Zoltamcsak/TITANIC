package com.rapidminer.titanic.titanic.passanger.service;

import com.rapidminer.titanic.titanic.passanger.Passenger;
import com.rapidminer.titanic.titanic.passanger.repository.PassengerRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PassengerServiceImpl implements PassengerService {

    private final PassengerRepository passengerRepository;

    public PassengerServiceImpl(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    @Override
    public List<Passenger> findAll() {
        return passengerRepository.findAll();
    }

    @Override
    public Passenger findOne(Long id) {
        return passengerRepository.getOne(id);
    }

    @Override
    public Passenger save(Passenger passenger) {
        return null;
    }

    @Override
    public List<Passenger> save(List<Passenger> passengers) {
        return passengerRepository.saveAll(passengers);
    }

    @Override
    public void delete(Long id) {

    }
}
