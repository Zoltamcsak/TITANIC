package com.rapidminer.titanic.titanic.passanger.repository;

import com.rapidminer.titanic.titanic.passanger.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
