package com.hillel.taxistation.impl;

import com.hillel.taxistation.TaxiStation;
import com.hillel.taxistation.models.Car;

public class TaxiStationBolt implements TaxiStation {

    private Car[] cars;

    public TaxiStationBolt() {
    }

    public TaxiStationBolt(Car[] cars) {
        this.cars = cars;
    }

    public double calculateCostOfTaxiStation() {
        double costOfTaxiStation = 0;
        for (Car car : cars) {
            costOfTaxiStation += car.getCost();
        }
        return costOfTaxiStation;
    }

    private Car[] extendArray(Car foundCar, Car[] coppiedArray) {
        if(coppiedArray == null) {
            Car[] extendedArray = new Car[1];
            extendedArray[0] = foundCar;
            return extendedArray;
        } else {
            Car[] extendedArray = new Car[coppiedArray.length + 1];
            for (int i = 0; i < coppiedArray.length; i++) {
                extendedArray[i] = coppiedArray[i];
            }
            extendedArray[coppiedArray.length] = foundCar;
            return extendedArray;
        }
    }

    public Car[] searchBySpeed(double min, double max) {
        Car[] foundCars = {};
        for (int i = 0; i < cars.length; i++) {
            if(cars[i].getSpeed() > min && cars[i].getSpeed() < max)
            foundCars = extendArray(cars[i], foundCars);     
            }
        return foundCars;
        }   
    
    public void sortByFuelConsumption() {
        Car temp;
        for (int i = 0; i < cars.length; i++) {
            for (int j = cars.length - 1; j > i; j--) {
                if (cars[j - 1].getFuelConsumption() > cars[j].getFuelConsumption()) {
                    temp = cars[j - 1];
                    cars[j - 1] = cars[j];
                    cars[j] = temp;
                }
            }
        }
    }
    
    public Car[] getCars() {
        return cars;
    }
    
    public void setCars(Car[] cars) {
        this.cars = cars;
    }

}
