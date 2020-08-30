package com.hillel.taxistation.models;

public class Sedan extends PassengerCar {
    
    private boolean isCabrio;

    public Sedan() {
    }

    public Sedan(String mark, double cost, double speed, double fuelConsumption,
            int countOfPassengerSeats, boolean isCabrio) {
        super(mark, cost, speed, fuelConsumption, countOfPassengerSeats);
        this.isCabrio = isCabrio;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("Is cabrio: " + isCabrio + " \n");
        return sb.toString();
    }
    
    public boolean isCabrio () {
        return isCabrio;
    }

}
