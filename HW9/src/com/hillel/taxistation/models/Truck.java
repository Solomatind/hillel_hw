package com.hillel.taxistation.models;

public class Truck extends Car {

    private double carryingСapacity;

    public Truck() {
    }

    public Truck(String mark, double cost, double speed, double fuelConsumption, double carryingCapacity) {
        super(mark, cost, speed, fuelConsumption);
        this.carryingСapacity = carryingCapacity;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("Carrying Capacity: " + carryingСapacity + " kg \n");
        return sb.toString();
    }
}
