package com.hillel.taxistation.models;

abstract public class Car {

    private double cost;
    private double fuelConsumption;
    private String mark;
    private double speed;

    public Car() {
    }

    public Car(String mark, double cost, double speed, double fuelConsumption) {
        this.mark = mark;
        this.cost = cost;
        this.speed = speed;
        this.fuelConsumption = fuelConsumption;
    }

    public double getCost() {
        return cost;
    }
    
    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public String getMark() {
        return mark;
    }

    public double getSpeed() {
        return speed;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public String toString() {
        String result = String.format("Mark: %s Cost: %.2f $ Speed:  %.2f km/h "
                + "Fuel Consumption:  %.2f l/100km ", mark, cost, speed, fuelConsumption);
        return result;
    }

}
