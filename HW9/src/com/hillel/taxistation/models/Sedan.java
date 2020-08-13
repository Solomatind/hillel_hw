package com.hillel.taxistation.models;

public class Sedan extends PassengerCar {

    public Sedan() {
    }

    public Sedan(String mark, double cost, double speed, double fuelConsumption, int countOfPassengerSeats) {
        super(mark, cost, speed, fuelConsumption, countOfPassengerSeats);
    }

}
