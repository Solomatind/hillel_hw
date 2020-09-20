package com.hillel.taxistation.models;

public class Minibus extends PassengerCar {

    public Minibus() {
    }

    public Minibus(String mark, double cost, double speed, double fuelConsumption, int countOfPassengerSeats) {
        super(mark, cost, speed, fuelConsumption, countOfPassengerSeats);
    }

}
