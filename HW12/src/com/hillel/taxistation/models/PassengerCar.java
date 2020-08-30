package com.hillel.taxistation.models;

abstract public class PassengerCar extends Car {

    private int countOfPassengerSeats;

    public PassengerCar() {
    }

    public PassengerCar(String mark, double cost, double speed, double fuelConsumption, int countOfPassengerSeats) {
        super(mark, cost, speed, fuelConsumption);
        this.countOfPassengerSeats = countOfPassengerSeats;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("Count of passenger seats: " + countOfPassengerSeats + "\n");
        return sb.toString();
    }
    
    public int getCountOfPassengerSeats() {
        return countOfPassengerSeats;
    }

}
