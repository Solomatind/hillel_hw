package com.hillel.taxistation.impl;

import java.util.Arrays;
import java.util.Comparator;

import com.hillel.taxistation.TaxiStation;
import com.hillel.taxistation.function.CarComparator;
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
        if (coppiedArray == null) {
            coppiedArray[0] = foundCar;
            return coppiedArray;
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
            if (cars[i].getSpeed() > min && cars[i].getSpeed() < max)
                foundCars = extendArray(cars[i], foundCars);
        }
        return foundCars;
    }
    
    public void sortByFuelConsumption() {
        Arrays.sort(cars, new Comparator<Car> () {
            public int compare(Car car1, Car car2) {
                return Double.compare(car1.getFuelConsumption(), car2.getFuelConsumption());
            }
        });
    }

    public void sortByFuelConsumptionWithReference() {
        Arrays.sort(cars, CarComparator::compare);
    }

    public void sortByFuelConsumptionWithLambda() {
        Arrays.sort(cars,
                (Comparator<Car>) (car1, car2) -> Double.compare(car1.getFuelConsumption(), car2.getFuelConsumption()));
    }

    public Car[] getCars() {
        return cars;
    }

    public void setCars(Car[] cars) {
        this.cars = cars;
    }

}
