package com.hillel.taxistation.models;

public class Truck extends Car {

    private double carryingCapacity;

    public Truck() {
    }

    public Truck(String mark, double cost, double speed, double fuelConsumption, double carryingCapacity) {
        super(mark, cost, speed, fuelConsumption);
        this.carryingCapacity = carryingCapacity;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("Carrying Capacity: " + carryingCapacity + " kg \n");
        return sb.toString();
    }
    
    public double getCarryingCapacity() {
        return carryingCapacity;
    }
    
}
