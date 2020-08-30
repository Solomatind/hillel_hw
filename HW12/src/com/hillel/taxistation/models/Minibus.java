package com.hillel.taxistation.models;

public class Minibus extends PassengerCar {
    
    private boolean isCargoPassenger;

    public Minibus() {
    }

    public Minibus(String mark, double cost, double speed, double fuelConsumption,
            int countOfPassengerSeats, boolean isCargoPassenger) {
        super(mark, cost, speed, fuelConsumption, countOfPassengerSeats);
        this.isCargoPassenger = isCargoPassenger;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("Is cargo-passenger type: " + isCargoPassenger + " \n");
        return sb.toString();
    }
    
    public boolean isCargoPassenger() {
        return isCargoPassenger;
    }

}
