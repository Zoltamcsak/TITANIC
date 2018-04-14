package com.rapidminer.titanic.titanic.passanger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Passenger {

    @Id
    @GeneratedValue
    private Long id;

    private String passengerClass;

    private String name;

    private String sex;

    private Integer age;

    private Integer nrOfSiblings;

    private Integer nrOfParent;

    private String ticketNumber;

    private Double fare;

    private String cabin;

    private String embarkation;

    private String lifeBoat;

    private boolean survived;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassengerClass() {
        return passengerClass;
    }

    public void setPassengerClass(String passengerClass) {
        this.passengerClass = passengerClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getNrOfSiblings() {
        return nrOfSiblings;
    }

    public void setNrOfSiblings(Integer nrOfSiblings) {
        this.nrOfSiblings = nrOfSiblings;
    }

    public int getNrOfParent() {
        return nrOfParent;
    }

    public void setNrOfParent(int nrOfParent) {
        this.nrOfParent = nrOfParent;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public Double getFare() {
        return fare;
    }

    public void setFare(Double fare) {
        this.fare = fare;
    }

    public String getCabin() {
        return cabin;
    }

    public void setCabin(String cabin) {
        this.cabin = cabin;
    }

    public String getEmbarkation() {
        return embarkation;
    }

    public void setEmbarkation(String embarkation) {
        this.embarkation = embarkation;
    }

    public String getLifeBoat() {
        return lifeBoat;
    }

    public void setLifeBoat(String lifeBoat) {
        this.lifeBoat = lifeBoat;
    }

    public boolean isSurvived() {
        return survived;
    }

    public void setSurvived(boolean survived) {
        this.survived = survived;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return nrOfParent == passenger.nrOfParent &&
                survived == passenger.survived &&
                Objects.equals(id, passenger.id) &&
                passengerClass == passenger.passengerClass &&
                Objects.equals(name, passenger.name) &&
                sex == passenger.sex &&
                Objects.equals(age, passenger.age) &&
                Objects.equals(nrOfSiblings, passenger.nrOfSiblings) &&
                Objects.equals(ticketNumber, passenger.ticketNumber) &&
                Objects.equals(fare, passenger.fare) &&
                Objects.equals(cabin, passenger.cabin) &&
                Objects.equals(embarkation, passenger.embarkation) &&
                Objects.equals(lifeBoat, passenger.lifeBoat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, passengerClass, name, sex, age, nrOfSiblings, nrOfParent, ticketNumber, fare, cabin, embarkation, lifeBoat, survived);
    }
}
