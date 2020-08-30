package com.hillel.taxistation.models;

public class Eco extends PassengerCar {

    private double chargeLevel;
    
    public Eco() {
    }

    public Eco(String mark, double cost, double speed, int countOfPassengerSeats,
            double chargeLevel) {
        super(mark, cost, speed, 0, countOfPassengerSeats);
        this.chargeLevel = chargeLevel;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("Charge level: " + chargeLevel + " A/h \n");
        return sb.toString();
    }
    
    public double getChargeLevel() {
        return chargeLevel;
    }

}
